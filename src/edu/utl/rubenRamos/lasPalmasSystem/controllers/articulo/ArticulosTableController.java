package edu.utl.rubenRamos.lasPalmasSystem.controllers.articulo;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Producto;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.ArticuloService;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.tasks.ArticuloTableService;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArticulosTableController implements Initializable {

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
    private TableColumn<Articulo, Double> tableColumPrecioFaltante;

    @FXML
    private TableColumn<Articulo, Integer> tableColumCantidad;

    @FXML
    private TableColumn<CategoriaArticulo, String> tableColumCategoria;

    private ArrayList<Articulo> listArticulos = new ArrayList<>();
    private ArticuloService articuloService = new ArticuloService();
    private ObservableList<Articulo> observableList = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        settingTable();
        loadingDataProceess();

        filteringData();
        selectedItem();
    }

    private void settingTable() {
        tableColumId.setCellValueFactory(new PropertyValueFactory<>("idArticulo"));
        tableColumNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        tableColumPrecioFaltante.setCellValueFactory(new PropertyValueFactory<>("precioFaltante"));
        tableColumCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tableColumCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriArticuloNameTable"));
    }

    private void filteringData() {
        FilteredList<Articulo> filteredData = new FilteredList<>(observableList, articuloResult -> true);

        textFieldSearch.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(art -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (art.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (art.getCategoriArticuloNameTable().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(art.getCantidad()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(art.getPrecioFaltante()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(art.getPrecioUnitario()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;
            });
        }));
        SortedList<Articulo> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }

    private void selectedItem() {
        final Articulo[] articulo = {new Articulo()};
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                articulo[0] = tableView.getSelectionModel().getSelectedItem();
                System.out.println(articulo[0].getNombre());
                pullingOutSelectedItemInfo(articulo[0]);
            }
        });
    }

    private Articulo pullingOutSelectedItemInfo(Articulo articulo) {
        System.out.println(articulo.getNombre());
        return articulo;
    }

    private void loadingDataProceess() {
        final ArticuloTableService articuloTableService = new ArticuloTableService();

        Region veil = new Region();
        veil.setStyle("-fx-background-color:rgba(0,0,0,0.4)");
        veil.setPrefHeight(400);
        veil.setPrefWidth(300);

        ProgressBar progressBar = new ProgressBar();

        progressBar.progressProperty().bind(articuloTableService.progressProperty());
        veil.visibleProperty().bind(articuloTableService.runningProperty());
        progressBar.visibleProperty().bind(articuloTableService.runningProperty());

        tableView.itemsProperty().bind(articuloTableService.valueProperty());


        stackPane.getChildren().addAll(veil, progressBar);
        articuloTableService.start();
    }

}
