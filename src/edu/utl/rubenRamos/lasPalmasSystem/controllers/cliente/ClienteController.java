package edu.utl.rubenRamos.lasPalmasSystem.controllers.cliente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.ClienteService;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ButtonsLogic;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import edu.utl.rubenRamos.lasPalmasSystem.utils.TooltipGenerator;
import edu.utl.rubenRamos.lasPalmasSystem.utils.Validators;
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
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {

    @FXML
    private SplitPane splitPaneArticulos;
    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXTextField txtApellido;
    @FXML
    private JFXTextField txtCiudad;
    @FXML
    private JFXTextField txtDireccion;
    @FXML
    private JFXTextField txtTelefono;
    @FXML
    private JFXTextField txtOrganizacion;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnCreate;
    @FXML
    private JFXButton btnClean;
    @FXML
    private StackPane stackPane;
    @FXML
    private JFXTextField textFieldSearch;
    @FXML
    private TableView<Cliente> tableView;
    @FXML
    private TableColumn<Cliente, Integer> tableColumId;
    @FXML
    private TableColumn<Cliente, String> tableColumNombre;
    @FXML
    private TableColumn<Cliente, String> tableColumApellido;
    @FXML
    private TableColumn<Cliente, String> tableColumDireccion;
    @FXML
    private TableColumn<Cliente, String> tableColumCiudad;
    @FXML
    private TableColumn<Cliente, String> tableColumTelefono;
    @FXML
    private TableColumn<Cliente, String> tableColumNombreCompania;

    private ClienteService clienteService = new ClienteService();
    private ArrayList<Cliente> clienteList = null;
    private Integer idClienteSeleccionado;
    private ObservableList<Cliente> observableList = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
    }

    private void initData() {
        addingListeners();
        settingTable();
        fetchingDataTable();
        filteringData();
        selectedItem();
        cleaningFields();
        addingTooltips();
        btnUpdate.setDisable(true);
    }

    private void addingListeners() {
        ArrayList<JFXTextField> fields = new ArrayList<>();
        fields.add(txtNombre);
        fields.add(txtApellido);
        fields.add(txtDireccion);
        fields.add(txtTelefono);
        btnCreate.setOnAction(actionEvent -> {
            if (Validators.formNotNull(fields)) {
                try {
                    Boolean flag = clienteService.createCliente(
                            txtNombre.getText(),
                            txtApellido.getText(),
                            txtDireccion.getText(),
                            txtCiudad.getText(),
                            txtTelefono.getText(),
                            txtOrganizacion.getText()
                    );
                    if (flag) {
                        ContextualWindow.contextualWindow("information", splitPaneArticulos, "El cliente se agregó con éxito.", "Información");
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
                Boolean flag = clienteService.updateCliente(
                        idClienteSeleccionado,
                        txtNombre.getText(),
                        txtApellido.getText(),
                        txtDireccion.getText(),
                        txtCiudad.getText(),
                        txtTelefono.getText(),
                        txtOrganizacion.getText()
                );
                if (flag) {
                    ContextualWindow.contextualWindow("information", splitPaneArticulos, "El cliente se actualizó con éxito.", "Información");
                    cleaningFields();
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
        tableColumId.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        tableColumNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableColumDireccion.setCellValueFactory(new PropertyValueFactory<>("direccionParticular"));
        tableColumCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        tableColumTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableColumNombreCompania.setCellValueFactory(new PropertyValueFactory<>("nombreOrganizacion"));
    }

    private void fetchingDataTable() {
        clienteList = clienteService.getAllCliente();
        observableList = FXCollections.observableArrayList(clienteList);
        tableView.setItems(observableList);
        tableView.refresh();
    }

    private void selectedItem() {
        try {
            tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cliente>() {
                @Override
                public void changed(ObservableValue<? extends Cliente> observableValue, Cliente clienteRe,
                                    Cliente clienteSelected) {
                    if (tableView.getSelectionModel().getSelectedItem() != null) {
                        idClienteSeleccionado = clienteSelected.getIdCliente();
                        txtNombre.setText(clienteSelected.getNombre());
                        txtApellido.setText(clienteSelected.getApellido());
                        txtDireccion.setText(clienteSelected.getDireccionParticular());
                        txtOrganizacion.setText(clienteSelected.getNombreOrganizacion());
                        txtTelefono.setText(clienteSelected.getTelefono());
                        txtCiudad.setText(clienteSelected.getCiudad());
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

    private void filteringData() {
        FilteredList<Cliente> filteredData = new FilteredList<Cliente>(FXCollections.observableArrayList(clienteList), cliente -> true);

        textFieldSearch.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(categoriaArticulo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (categoriaArticulo.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (categoriaArticulo.getApellido().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (categoriaArticulo.getCiudad().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (categoriaArticulo.getDireccionParticular().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (categoriaArticulo.getNombreOrganizacion().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (categoriaArticulo.getCiudad().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(categoriaArticulo.getTelefono()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        }));
        SortedList<Cliente> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }

    private void cleaningFields() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtOrganizacion.setText("");
        txtTelefono.setText("");
        txtCiudad.setText("");
        observableList.clear();
        fetchingDataTable();
        filteringData();
        btnUpdate.setDisable(true);
        btnCreate.setDisable(false);
    }

    private void addingTooltips() {
        txtNombre.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtApellido.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtDireccion.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtTelefono.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtCiudad.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
    }
}


