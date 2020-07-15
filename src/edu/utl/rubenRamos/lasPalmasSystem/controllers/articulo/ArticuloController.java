package edu.utl.rubenRamos.lasPalmasSystem.controllers.articulo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.ArticuloService;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.CategoriaArticuloService;
import edu.utl.rubenRamos.lasPalmasSystem.utils.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArticuloController implements Initializable {

    /*Left side items*/
    @FXML
    private SplitPane splitPaneArticulos;
    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXTextField txtPrecioUnitario;
    @FXML
    private JFXTextField txtPrecioFaltante;
    @FXML
    private JFXTextField txtCantidad;
    @FXML
    private JFXComboBox<CategoriaArticulo> comboCategoria;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnClean;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnCreate;
    @FXML
    private JFXButton btnLoadImage;
    @FXML
    private BorderPane borderPaneSide;
    @FXML
    private Pane pane;
    /*Right side items*/
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

    private String imagePath = " ";
    private List<JFXTextField> fields = new ArrayList<>();
    private ArticuloService articuloService = new ArticuloService();
    private Integer idSelectedItem;
    private ArrayList<Articulo> articuloList;
    private ObservableList<Articulo> observableList = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
    }

    private void initData() {
        articuloList = new ArrayList<>();
        ArrayList<JFXTextField> listDoubles = new ArrayList<>();
        listDoubles.add(txtPrecioFaltante);
        listDoubles.add(txtPrecioUnitario);
        fillingComboBox();
        addingListeners();
        settingTable();
        fetchingDataTable();
        filteringData();
        selectedItem();
        addingTooltips();

        Validators.intValitador(txtCantidad);
        Validators.doubleValitadorList(listDoubles);
        ButtonsLogic.disableButtons(btnUpdate, btnDelete);

    }

    private void fillingComboBox() {
        CategoriaArticuloService categoriaArticuloService = new CategoriaArticuloService();
        ArrayList<CategoriaArticulo> categoriaList = categoriaArticuloService.getAllCategoriaArticulo();
        comboCategoria.setItems(FXCollections.observableArrayList(categoriaList));
        comboCategoria.getSelectionModel().select(0);
        comboCategoria.setConverter(new StringConverter<CategoriaArticulo>() {
            @Override
            public String toString(CategoriaArticulo categoriaArticulo) {
                return categoriaArticulo.getNombre();
            }

            @Override
            public CategoriaArticulo fromString(String string) {
                for (CategoriaArticulo categoria : comboCategoria.getItems()) {
                    if (categoria.getNombre().equals(string)) return categoria;
                }
                return null;
            }
        });
    }

    private void addingListeners() {
        /*Se llena un arraylist para hacer la validacion de campos not null*/
        fields.add(txtCantidad);
        fields.add(txtNombre);
        fields.add(txtPrecioFaltante);
        fields.add(txtPrecioUnitario);

        btnCreate.setOnAction(actionEvent -> {
            if (Validators.formNotNull(fields)) {
                /*Getting data from comboBox*/
                SingleSelectionModel<CategoriaArticulo> listCategoria = comboCategoria.getSelectionModel();
                CategoriaArticulo categoriaArticulo = listCategoria.getSelectedItem();
                try {
                    Boolean flag = articuloService.createArticulo(
                            txtNombre.getText(), Double.parseDouble(txtPrecioUnitario.getText()),
                            Double.parseDouble(txtPrecioFaltante.getText()),
                            Integer.parseInt(txtCantidad.getText()),
                            categoriaArticulo.getIdCategoria(),
                            imagePath
                    );
                    if (flag) {
                        ContextualWindow.contextualWindow("information", splitPaneArticulos, "El artículo se agregó con éxito.", "Información");
                        cleaningFields();
                    }
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                    ContextualWindow.contextualWindow("error", splitPaneArticulos, "Vuelva a internarlo", "Error");
                }
            } else {
                ContextualWindow.contextualWindow("warning", splitPaneArticulos, "Los campos con * son necesario de completar", "Advertencia");
            }
        });
        btnUpdate.setOnAction(actionEvent -> {
            if (Validators.formNotNull(fields)) {
                Boolean flag = articuloService.updateArticulo(idSelectedItem, txtNombre.getText(), Double.parseDouble(txtPrecioUnitario.getText()),
                        Double.parseDouble(txtPrecioFaltante.getText()),
                        Integer.parseInt(txtCantidad.getText()),
                        comboCategoria.getSelectionModel().getSelectedItem().getIdCategoria(),
                        imagePath);
                if (flag) {
                    ContextualWindow.contextualWindow("information", splitPaneArticulos, "El artículo se actualizó con éxito.", "Información");
                    cleaningFields();
                }
            } else {
                ContextualWindow.contextualWindow("warning", splitPaneArticulos, "Los campos con * son necesario de completar", "Advertencia");
            }
        });
        btnDelete.setOnAction(actionEvent -> {
            boolean flag = ContextualWindow.contextualOptionWarningWindow(splitPaneArticulos, "¿Esta seguro de eliminar este artículo?\n ".concat(txtNombre.getText()),
                    "Confirmación");
            if (flag) {
                boolean flagT = articuloService.deleteArticulo(idSelectedItem);
                if (flagT) {
                    ContextualWindow.contextualWindow("information", splitPaneArticulos, "El artículo se eliminó con éxito.", "Información");
                    cleaningFields();
                }

            }
        });
        btnLoadImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imagePath = ImageLoader.fileChooser(pane, splitPaneArticulos);
            }
        });
        btnClean.setOnMouseClicked(mouseEvent -> {
            cleaningFields();
        });
    }

    private void selectedItem() {
        try {
            tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Articulo>() {
                @Override
                public void changed(ObservableValue<? extends Articulo> observableValue, Articulo articulo,
                                    Articulo articuloSeleccionado) {
                    if (tableView.getSelectionModel().getSelectedItem() != null) {
                        idSelectedItem = articuloSeleccionado.getIdArticulo();
                        txtNombre.setText(articuloSeleccionado.getNombre());
                        txtCantidad.setText(String.valueOf(articuloSeleccionado.getCantidad()));
                        txtPrecioUnitario.setText(String.valueOf(articuloSeleccionado.getPrecioUnitario()));
                        txtPrecioFaltante.setText(String.valueOf(articuloSeleccionado.getPrecioFaltante()));
                        comboCategoria.getSelectionModel().select(articuloSeleccionado.getCategoriaArticulo());
                        ButtonsLogic.enableButtons(btnCreate, btnUpdate, btnDelete);
                        if (articuloSeleccionado.getPathImage() != null) {
                            ImageLoader.loadFromPath(articuloSeleccionado.getPathImage(), pane);
                        } else {
                            ImageLoader.loadFromPath("", pane);
                        }
                    }
                }
            });
        } catch (
                NullPointerException exception) {
            exception.printStackTrace();
        }
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
        FilteredList<Articulo> filteredData = new FilteredList<Articulo>(FXCollections.observableArrayList(articuloList), cliente -> true);
        textFieldSearch.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(articulo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (articulo.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (articulo.getCategoriaArticuloFormaTable().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(articulo.getPrecioFaltante()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(articulo.getPrecioUnitario()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(articulo.getCantidad()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(articulo.getIdArticulo()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (articulo.getCategoriaArticuloFormaTable().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (articulo.getCategoriaArticulo().getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        }));
        SortedList<Articulo> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }

    private void fetchingDataTable() {
        articuloList = articuloService.getAllArticulos();
        observableList = FXCollections.observableArrayList(articuloList);
        tableView.setItems(observableList);
        tableView.refresh();
    }

    private void cleaningFields() {
        comboCategoria.getSelectionModel().select(0);
        btnCreate.setDisable(false);
        ButtonsLogic.disableButtons(btnUpdate, btnDelete);
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecioFaltante.setText("");
        txtPrecioUnitario.setText("");
        ImageLoader.loadFromPath("", pane);
        observableList.clear();
        fetchingDataTable();
        filteringData();
    }

    private void addingTooltips() {
        String value = "Campo obligatorio";
        txtNombre.setTooltip(TooltipGenerator.regularTooltip(value));
        txtCantidad.setTooltip(TooltipGenerator.regularTooltip(value));
        txtPrecioFaltante.setTooltip(TooltipGenerator.regularTooltip(value));
        txtPrecioUnitario.setTooltip(TooltipGenerator.regularTooltip(value));
        comboCategoria.setTooltip(TooltipGenerator.regularTooltip(value));
    }
}
