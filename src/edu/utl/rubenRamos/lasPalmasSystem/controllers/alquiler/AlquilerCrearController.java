package edu.utl.rubenRamos.lasPalmasSystem.controllers.alquiler;

import com.jfoenix.controls.*;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.ClienteService;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import edu.utl.rubenRamos.lasPalmasSystem.utils.Validators;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class AlquilerCrearController implements Initializable {

    /*
     * TODO TENGO QUE AGREGAR LAS FECHA DEL PEDIDO A LA RESERVACION, PARA CALCULAR EL MONTO TOTAL TAMBIEN !!!!!!!!
     *  SOLAMENTE ESTOY HACIENDO EL CALCULO POR UN DÍA
     *  */

    @FXML
    private JFXComboBox<String> comboCliente;
    @FXML
    private JFXDatePicker datePickerFechaInicio;
    @FXML
    private JFXDatePicker datePickerFechaFin;
    @FXML
    private JFXButton btnConsultar;
    @FXML
    private StackPane stackPane;
    @FXML
    private JFXTextField textFieldSearch;
    @FXML
    private TableView<Articulo> tableView;
    @FXML
    private TableColumn<Articulo, Integer> tableColumId;
    @FXML
    private TableColumn<Articulo, String> tableColumNombre;
    @FXML
    private TableColumn<Articulo, Double> tableColumPrecioUnitario;
    @FXML
    private TableColumn<Articulo, Integer> tableColumCantidad;
    @FXML
    private TableColumn<CategoriaArticulo, String> tableColumCategoria;
    @FXML
    private TableColumn<CategoriaArticulo, String> tableColumForma;
    @FXML
    private AnchorPane anchorLeft;
    @FXML
    private JFXListView<Node> listView;
    @FXML
    private Text txtTotal;
    @FXML
    private Text txtDias;
    @FXML
    private JFXButton btnAddUser;


    private Map<Integer, Integer> verify = new HashMap<>();
    private double total = 0.0;
    private Integer dias = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
    }

    private void initData() {
        settingTable();
        addingButtonsToTable();
        settingUpCalendars();
        fillingComboBox();
        addingListeners();
    }

    private void settingTable() {
        tableColumId.setCellValueFactory(new PropertyValueFactory<>("idArticulo"));
        tableColumNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        tableColumCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tableColumCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriArticuloNameTable"));
        tableColumForma.setCellValueFactory(new PropertyValueFactory<>("categoriaArticuloFormaTable"));
    }

    private void fillingComboBox() {
        ClienteService clienteService = new ClienteService();
        ArrayList<Cliente> clientes = clienteService.getAllCliente();
        ArrayList<String> names = new ArrayList<>();

        comboCliente.getItems().addAll(names);
        comboCliente.getSelectionModel().select(0);

        for (Cliente cliente : clientes) {
            names.add(cliente.getNombre().concat(" ").concat(cliente.getApellido()));
        }

        JFXAutoCompletePopup<String> autoCompletePopup = new JFXAutoCompletePopup<>();
        autoCompletePopup.getSuggestions().addAll(names);

        autoCompletePopup.setSelectionHandler(event -> {
            comboCliente.setValue(event.getObject());
        });

        TextField editor = comboCliente.getEditor();
        editor.textProperty().addListener(observable -> {
            autoCompletePopup.filter(item -> item.toLowerCase().contains(editor.getText().toLowerCase()));
            //Hide the autocomplete popup if the filtered suggestions is empty or when the box's original popup is open
            if (autoCompletePopup.getFilteredSuggestions().isEmpty() || comboCliente.showingProperty().get()) {
                autoCompletePopup.hide();
            } else {
                autoCompletePopup.show(editor);
            }
        });
    }

    private void creatingItem(Integer id, String nombre, Double costo, Integer disponibles, Double precioUnitario, Integer index) throws IOException {
        String font = "Roboto";
        Map<AnchorPane, Integer> colum = new HashMap<>();
        AtomicReference<Integer> auxCantidadEscrita = new AtomicReference<>(0);
        AtomicReference<Integer> auxDias = new AtomicReference<>(0);
        verify.put(id, id);

        /*Setting items*/
        AnchorPane anchorPane = new AnchorPane();
        HBox mainHBox = new HBox();
        colum.put(anchorPane, index);


        /*HBox*/
        Text text = new Text("Confirmar");
        JFXButton buttonConfirmar = new JFXButton(text.getText());
        buttonConfirmar.setTextFill(Color.WHITE);
        mainHBox.setMinHeight(73);
        mainHBox.setMinWidth(Region.USE_COMPUTED_SIZE);
        mainHBox.setFillHeight(true);
        mainHBox.setAlignment(Pos.CENTER);
        mainHBox.setSpacing(50.0);

        /*vBoxArticulo*/
        VBox vBoxArticulo = new VBox();
        Text textNombreArticulo = new Text(nombre);
        Text textCategoriaArticulo = new Text("Artículo");
        textCategoriaArticulo.setFont(Font.font(font));
        textNombreArticulo.setFont(Font.font(font, 20.0));
        vBoxArticulo.getChildren().add(textCategoriaArticulo);
        vBoxArticulo.getChildren().add(textNombreArticulo);
        vBoxArticulo.setSpacing(15.0);
        vBoxArticulo.setAlignment(Pos.CENTER);

        /*vBoxDisponibles*/
        VBox vBoxArticuloDisponibles = new VBox();
        Text textCantidadArticulo = new Text(disponibles.toString());
        Text textDisponibles = new Text("Disponible");
        textCantidadArticulo.setFont(Font.font(font, 17.0));
        textDisponibles.setFont(Font.font(font));

        vBoxArticuloDisponibles.getChildren().add(textDisponibles);
        vBoxArticuloDisponibles.getChildren().add(textCantidadArticulo);
        vBoxArticuloDisponibles.setSpacing(15.0);
        vBoxArticuloDisponibles.setAlignment(Pos.CENTER);

        /*vBoxCantidad*/
        VBox vBoxCantidad = new VBox();
        Text textCantidad = new Text("Cantidad");
        vBoxCantidad.getChildren().add(textCantidad);
        vBoxCantidad.setSpacing(15.0);
        vBoxCantidad.setAlignment(Pos.CENTER);


        /*VBox - PrecioUnitario*/
        VBox vBoxPrecioUnitario = new VBox();
        vBoxPrecioUnitario.getChildren().add(new Text("Precio Unitario"));
        vBoxPrecioUnitario.getChildren().add(new Text(costo.toString()));
        vBoxPrecioUnitario.setAlignment(Pos.CENTER);

        /*TextFiel - Cantidad Escrita*/
        JFXTextField txtFieldCantidad = new JFXTextField();
        Validators.intValitador(txtFieldCantidad);
        vBoxCantidad.getChildren().add(txtFieldCantidad);

        /*AnchorPane*/
        anchorPane.setMinWidth(297);
        anchorPane.setMinHeight(73);

        /*Buttons*/
        buttonConfirmar.setStyle("-fx-background-color: #4286f4");
        Button buttonDelete = new Button();
        buttonDelete.setStyle("-fx-shape: 'M3 6l3 18h12l3-18h-18zm19-4v2h-20v-2h5.711c.9 0 1.631-1.099 1.631-2h5.316c0 .901.73 2 1.631 2h5.711z'");
        buttonDelete.setPrefWidth(30.0);
        buttonDelete.setPrefHeight(30.0);

        /*Adding items*/
        mainHBox.getChildren().add(vBoxArticulo);
        mainHBox.getChildren().add(vBoxArticuloDisponibles);
        mainHBox.getChildren().add(vBoxPrecioUnitario);
        mainHBox.getChildren().add(vBoxCantidad);
        mainHBox.getChildren().add(buttonDelete);
        mainHBox.getChildren().add(buttonConfirmar);

        mainHBox.setHgrow(vBoxArticulo, Priority.ALWAYS);
        mainHBox.setHgrow(vBoxArticuloDisponibles, Priority.ALWAYS);
        mainHBox.setHgrow(vBoxCantidad, Priority.ALWAYS);
        mainHBox.setHgrow(buttonConfirmar, Priority.ALWAYS);
        mainHBox.setHgrow(vBoxPrecioUnitario, Priority.ALWAYS);

        anchorPane.getChildren().add(mainHBox);
        listView.getItems().add(anchorPane);

        /*Listeners*/
        buttonDelete.setOnMouseClicked(mouseEvent -> {
            listView.getItems().remove(anchorPane);
            verify.remove(id);
            total = total - ((auxCantidadEscrita.get() * precioUnitario) * auxDias.get());
            txtTotal.setText(String.valueOf(total));
        });

        buttonConfirmar.setOnMouseClicked(mouseEvent -> {
            try {
                Integer cantidadEscrita = Integer.parseInt(txtFieldCantidad.getText());

                if (cantidadEscrita > disponibles) {
                    ContextualWindow.contextualWindow("warning", anchorLeft, "El número de artículos es mayor a la disponible.", "Advertencia");
                    txtFieldCantidad.setText(String.valueOf(0));
                } else if (cantidadEscrita == 0) {
                    ContextualWindow.contextualWindow("warning", anchorLeft, "La cantidad mínima es 1.", "Advertencia");
                    txtFieldCantidad.setText(String.valueOf(0));
                } else {
                    double subtotalDouble = (cantidadEscrita * precioUnitario) * dias;
                    auxCantidadEscrita.set(cantidadEscrita);
                    auxDias.set(dias);
                    try {
                        mainHBox.getChildren().get(6);
                    } catch (IndexOutOfBoundsException exception) {
                        VBox vBoxtotal = new VBox();
                        Text subtotal = new Text(String.valueOf(subtotalDouble));
                        subtotal.setFont(Font.font(17));
                        vBoxtotal.getChildren().add(new Text("Subtotal:"));
                        vBoxtotal.getChildren().add(subtotal);
                        vBoxtotal.setSpacing(15.0);
                        vBoxtotal.setAlignment(Pos.CENTER);
                        mainHBox.getChildren().add(vBoxtotal);

                        total = total + subtotalDouble;
                        txtTotal.setText(String.valueOf(total));
                    }
                }
            } catch (NumberFormatException exception) {
                ContextualWindow.contextualWindow("warning", anchorLeft, "La cantidad mínima es 1.", "Advertencia");
                txtFieldCantidad.setText(String.valueOf(0));
            }
        });
    }

    private void addingButtonsToTable() {
        TableColumn actionCol = new TableColumn("Agregar");
        actionCol.setStyle("-fx-alignment: CENTER-RIGHT;");

        Callback<TableColumn<Articulo, String>, TableCell<Articulo, String>> cellFactory
                =
                new Callback<TableColumn<Articulo, String>, TableCell<Articulo, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Articulo, String> param) {
                        final TableCell<Articulo, String> cell = new TableCell<Articulo, String>() {

                            final JFXButton jfxButton = new JFXButton("Agregar");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    jfxButton.setStyle("-fx-background-color: #009688");
                                    jfxButton.setTextFill(Color.WHITE);
                                    jfxButton.setOnAction(actionEvent -> {
                                        Integer id = verify.get(tableView.getItems().get(getIndex()).getIdArticulo());
                                        if (id == null) {
                                            jfxButton.setStyle("-fx-background-color: #006c96");
                                            try {
                                                creatingItem(
                                                        tableView.getItems().get(getIndex()).getIdArticulo(),
                                                        tableView.getItems().get(getIndex()).getNombre(),
                                                        tableView.getItems().get(getIndex()).getPrecioUnitario(),
                                                        tableView.getItems().get(getIndex()).getCantidad(),
                                                        tableView.getItems().get(getIndex()).getPrecioUnitario(),
                                                        getIndex()
                                                );
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    setGraphic(jfxButton);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory(cellFactory);
        tableView.getColumns().add(actionCol);
    }

    private void addingListeners() {
        datePickerFechaFin.setOnAction(actionEvent -> {

        });
        btnAddUser.setOnAction(actionEvent -> {
            addUser();
        });
        btnConsultar.setOnAction(actionEvent -> {
            ZoneId defaultZoneId = ZoneId.systemDefault();
            LocalDate localDateFin = datePickerFechaFin.getValue();
            LocalDate localDateInicio = datePickerFechaInicio.getValue();
            if (localDateFin == null || localDateInicio == null) {
                ContextualWindow.contextualWindow("warning", anchorLeft, "Campos vacíos", "Amabas fechas deben estar completas.");
            } else {
                Date dateInicio = Date.from(localDateInicio.atStartOfDay(defaultZoneId).toInstant());
                Date dateFin = Date.from(localDateFin.atStartOfDay(defaultZoneId).toInstant());
                dias = (localDateFin.getDayOfYear() - localDateInicio.getDayOfYear()) + 1;
                txtDias.setText(String.valueOf(dias));
                checkingUpDates(dateInicio, dateFin);
            }
        });
    }

    private void settingUpCalendars() {
        datePickerFechaInicio.setDayCellFactory(picker -> new DateCell() {
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        LocalDate today = LocalDate.now();
                        setDisable(empty || date.compareTo(today) < 0);
                    }
                }
        );
        datePickerFechaFin.setDayCellFactory(picker -> new DateCell() {
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        LocalDate today = LocalDate.now();
                        setDisable(empty || date.compareTo(today) < 0);
                    }
                }
        );
        datePickerFechaInicio.setConverter(new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null)
                    return "";
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
        datePickerFechaFin.setConverter(new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null)
                    return "";
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
    }

    private void addUser() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../../views/cliente/crear-cliente.fxml"));
            Stage stage = new Stage();
            stage.setOnCloseRequest(windowEvent -> {
                fillingComboBox();
            });
            stage.setTitle("Agregar nuevo cliente");
            stage.setScene(new Scene(root, 450, 450));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkingUpDates(Date fechaInicio, Date fechFin) {

        if (fechFin.before(fechaInicio)) {
            ContextualWindow.contextualWindow("error", anchorLeft, "El fin del alquiler no puede empezar antes del inicio.", "Advertencia");
        }



        /*TODO Consultar todos los articulos disponibles para ser rentados entre estas fechas
         * //        fetchingDataTable();
         *
         * */
    }
}
