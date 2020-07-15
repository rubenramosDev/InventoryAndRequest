package edu.utl.rubenRamos.lasPalmasSystem.controllers.articulo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.CategoriaArticuloService;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CategoriaArticuloController implements Initializable {
    @FXML
    private SplitPane splitPaneArticulos;
    @FXML
    private JFXTextField txtNombreCategoria;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnCreate;
    @FXML
    private JFXButton btnClean;
    @FXML
    private JFXTextField textFieldSearch;
    @FXML
    private TableView<CategoriaArticulo> tableView;
    @FXML
    private TableColumn<CategoriaArticulo, Integer> tableColumId;
    @FXML
    private TableColumn<CategoriaArticulo, String> tableColumNombre;

    private CategoriaArticuloService categoriaArticuloService = new CategoriaArticuloService();
    private ArrayList<CategoriaArticulo> categoriaArticulosList = null;
    private Integer idSelectedCategoriaArticulo;
    private ObservableList<CategoriaArticulo> observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
    }

    private void initData() {
        settingTable();
        fetchingDataTable();
        btnUpdate.setDisable(true);
        filteringData();
        selectedItem();
        addingListeners();
    }

    private void addingListeners() {
        btnCreate.setOnAction(actionEvent -> {
            if (!txtNombreCategoria.getText().isEmpty()) {
                try {
                    Boolean flag = categoriaArticuloService.createCategoriaArticulo(txtNombreCategoria.getText());
                    if (flag) {
                        ContextualWindow.contextualWindow("information", splitPaneArticulos, "La categoría se agregó con éxito.", "Información");
                        cleaningFields();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                ContextualWindow.contextualWindow("warning", splitPaneArticulos, "Los campos con * son necesario de completar", "Advertencia");
            }
        });

        btnUpdate.setOnAction(actionEvent -> {
            if (!txtNombreCategoria.getText().isEmpty()) {
                try {
                    Boolean flag = categoriaArticuloService.updateCategoriaArticulo(txtNombreCategoria.getText(), idSelectedCategoriaArticulo);
                    if (flag) {
                        ContextualWindow.contextualWindow("information", splitPaneArticulos, "La categoría se actualizó con éxito.", "Información");
                        cleaningFields();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                ContextualWindow.contextualWindow("warning", splitPaneArticulos, "Los campos con * son necesario de completar", "Advertencia");
            }
        });

        btnClean.setOnAction(actionEvent -> {
            cleaningFields();
        });
    }

    private void settingTable() {
        tableColumId.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));
        tableColumNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    }

    private void selectedItem() {
        try {
            tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CategoriaArticulo>() {
                @Override
                public void changed(ObservableValue<? extends CategoriaArticulo> observableValue, CategoriaArticulo articulo,
                                    CategoriaArticulo categoriaArtSeleccionada) {
                    if (tableView.getSelectionModel().getSelectedItem() != null) {
                        idSelectedCategoriaArticulo = categoriaArtSeleccionada.getIdCategoria();
                        txtNombreCategoria.setText(categoriaArtSeleccionada.getNombre());
                        btnUpdate.setDisable(false);
                        btnCreate.setDisable(true);
                    }
                }
            });
        } catch (
                NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    private void fetchingDataTable() {
        categoriaArticulosList = categoriaArticuloService.getAllCategoriaArticulo();
        observableList = FXCollections.observableArrayList(categoriaArticulosList);
        tableView.setItems(observableList);
        tableView.refresh();
    }

    private void filteringData() {
        FilteredList<CategoriaArticulo> filteredData = new FilteredList<CategoriaArticulo>(FXCollections.observableArrayList(categoriaArticulosList), categoriaArticulo -> true);

        textFieldSearch.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(categoriaArticulo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (categoriaArticulo.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;
            });
        }));
        SortedList<CategoriaArticulo> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }

    private void cleaningFields() {
        txtNombreCategoria.setText("");
        observableList.clear();
        fetchingDataTable();
        filteringData();
        btnUpdate.setDisable(true);
        btnCreate.setDisable(false);
    }
}
