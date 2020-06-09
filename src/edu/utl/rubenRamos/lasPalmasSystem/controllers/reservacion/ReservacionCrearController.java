package edu.utl.rubenRamos.lasPalmasSystem.controllers.reservacion;

import com.jfoenix.controls.*;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.tasks.ArticuloTableService;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import edu.utl.rubenRamos.lasPalmasSystem.utils.Validators;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ReservacionCrearController implements Initializable {

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
    private SplitPane splitPaneVertical;
    @FXML
    private JFXListView<Node> listView;
    @FXML
    private Text txtTotal;


    private Map<Integer, Integer> verify = new HashMap<>();
    private double total = 0.0;

    private ArticuloTableService articuloTableService = new ArticuloTableService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
    }

    private void initData() {
        settingTable();
        fetchingDataTable();
        addingButtons();
    }

    private void settingTable() {
        tableColumId.setCellValueFactory(new PropertyValueFactory<>("idArticulo"));
        tableColumNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        tableColumCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tableColumCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriArticuloNameTable"));
        tableColumForma.setCellValueFactory(new PropertyValueFactory<>("categoriaArticuloFormaTable"));
    }


    private void creatingItem(Integer id, String nombre, Double costo, Integer disponibles, Double precioUnitario, Integer index) throws IOException {
        String font = "Roboto";
        verify.put(id, id);
        Map<AnchorPane, Integer> colum = new HashMap<>();
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

        /*ComboBox*/
        JFXTextField txtFieldCantidad = new JFXTextField();
        txtFieldCantidad.setText(String.valueOf(0));
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
            txtTotal.setText(String.valueOf(total));
        });

        buttonConfirmar.setOnMouseClicked(mouseEvent -> {
            Integer cantidadEscrita = Integer.parseInt(txtFieldCantidad.getText());
            if (cantidadEscrita > disponibles) {
                ContextualWindow.contextualWindow("warning", splitPaneVertical, "El número de artículos es mayor al disponible.", "Advertencia");
                txtFieldCantidad.setText(String.valueOf(0));
            } else if (cantidadEscrita == 0) {
                ContextualWindow.contextualWindow("warning", splitPaneVertical, "La cantidad mínima es 1.", "Advertencia");
                txtFieldCantidad.setText(String.valueOf(0));
            } else {
                double subtotalDouble = cantidadEscrita * precioUnitario;
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

                mainHBox.getChildren().remove(6);
                VBox vBoxtotal = new VBox();
                Text subtotal = new Text(String.valueOf(cantidadEscrita * precioUnitario));
                subtotal.setFont(Font.font(17));
                vBoxtotal.getChildren().add(new Text("Subtotal:"));
                vBoxtotal.getChildren().add(subtotal);
                vBoxtotal.setSpacing(15.0);
                vBoxtotal.setAlignment(Pos.CENTER);
                mainHBox.getChildren().add(vBoxtotal);
                total = total + subtotalDouble;
                txtTotal.setText(String.valueOf(total));
            }
        });
    }

    private void fetchingDataTable() {
        Region veil = new Region();
        ProgressBar progressBar = new ProgressBar();

        veil.setStyle("-fx-background-color:rgba(0,0,0,0.4)");
        veil.setPrefHeight(400);
        veil.setPrefWidth(300);

        progressBar.progressProperty().bind(articuloTableService.progressProperty());
        veil.visibleProperty().bind(articuloTableService.runningProperty());
        progressBar.visibleProperty().bind(articuloTableService.runningProperty());

        tableView.itemsProperty().bind(articuloTableService.valueProperty());

        stackPane.getChildren().addAll(veil, progressBar);
        articuloTableService.start();
        articuloTableService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                tableView.itemsProperty().unbind();
//                filteringData();
//                selectedItem();
            }
        });
    }

    private void addingButtons() {
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
}
