package edu.utl.rubenRamos.lasPalmasSystem.controllers.reservacion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.ArticuloService;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.tasks.ArticuloTableService;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
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
    private JFXListView<Node> jfxListView;

    private ArticuloTableService articuloTableService = new ArticuloTableService();
    private ArticuloService articuloService = new ArticuloService();

    public ReservacionCrearController() {
    }

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
                                    jfxButton.setOnAction(actionEvent -> {
                                        jfxButton.setStyle("-fx-background-color: #006c96");
                                        jfxButton.setText("Seleccionado");
                                        jfxButton.setDisable(true);
                                        try {
                                            addingValue(tableView.getItems().get(getIndex()).getNombre());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
//                                        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
                                    });

//                                    Person person = getTableView().getItems().get(getIndex());
//                                    System.out.println(person.getFirstName()
//                                            + "   " + person.getLastName());
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

    private void addingValue(String nombre) throws IOException {
        AnchorPane anchorPane = new AnchorPane();
        HBox hBox = new HBox();
        Text text = new Text(nombre);
        JFXButton buttonCancelar = new JFXButton("Eliminar");
        JFXButton buttonConfirmar = new JFXButton("Confirmar");

        anchorPane.setMinWidth(297);
        anchorPane.setMinHeight(73);
        hBox.setFillHeight(true);
        hBox.setMinHeight(73);
        hBox.setMinWidth(297);
        buttonCancelar.setStyle("-fx-background-color: #FF4B2B");
        buttonConfirmar.setStyle("-fx-background-color: #4286f4");

        hBox.setSpacing(50.0);
        hBox.getChildren().add(text);
        hBox.getChildren().add(buttonCancelar);
        hBox.getChildren().add(buttonConfirmar);
        anchorPane.getChildren().add(hBox);
        jfxListView.getItems().add(anchorPane);

    }
}
