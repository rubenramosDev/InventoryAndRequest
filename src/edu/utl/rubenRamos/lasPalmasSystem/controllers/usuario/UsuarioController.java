package edu.utl.rubenRamos.lasPalmasSystem.controllers.usuario;

import com.jfoenix.controls.*;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Usuario;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.UsuarioService;
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
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {

    @FXML
    private SplitPane splitPaneArticulos;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtApellido;

    @FXML
    private JFXTextField txtUsuario;

    @FXML
    private JFXComboBox<String> comboPrivilegios;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private Button btnEye;

    @FXML
    private JFXToggleButton JFXtogleButtonActivo;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnCreate;

    @FXML
    private JFXButton btnClean;

    @FXML
    private JFXTextField textFieldSearch;

    @FXML
    private TableView<Usuario> tableView;

    @FXML
    private TableColumn<Usuario, Integer> tableColumId;

    @FXML
    private TableColumn<Usuario, String> tableColumNombre;

    @FXML
    private TableColumn<Usuario, String> tableColumApellido;

    @FXML
    private TableColumn<Usuario, String> tableColumUsuario;

    @FXML
    private TableColumn<Usuario, Boolean> tableColumEstatus;

    @FXML
    private TableColumn<Usuario, String> tableColumPassword;

    @FXML
    private TableColumn<Usuario, String> tableColumPrivilegios;


    private UsuarioService usuarioService = new UsuarioService();
    private ArrayList<Usuario> usuarioList = null;
    private Integer idUsaurioSeleccionado;
    private ObservableList<Usuario> observableList = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
    }

    private void initData() {
        ButtonsLogic.disableButtons(btnUpdate, btnDelete);
        fillingComboBox();
        addingListeners();
        settingTable();
        fetchingDataTable();
        filteringData();
        addingTooltips();
        selectedItem();
    }

    private void fillingComboBox() {
        comboPrivilegios.setItems(FXCollections.observableArrayList("Regular", "Super Usuario"));
    }

    private void addingListeners() {
        ArrayList<JFXTextField> fields = new ArrayList<>();
        fields.add(txtNombre);
        fields.add(txtApellido);
        fields.add(txtUsuario);
        btnCreate.setOnAction(actionEvent -> {
            if (Validators.formNotNull(fields) && !txtPassword.getText().isEmpty()) {
                try {
                    Boolean flag = usuarioService.createUsuario(
                            txtNombre.getText(),
                            txtApellido.getText(),
                            txtUsuario.getText(),
                            txtPassword.getText(),
                            comboPrivilegios.getSelectionModel().getSelectedItem()
                    );
                    if (flag) {
                        ContextualWindow.contextualWindow("information", splitPaneArticulos, "El usuario se agregó con éxito.", "Información");
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
            if (Validators.formNotNull(fields) && !txtPassword.getText().isEmpty()) {
                Boolean flag = usuarioService.updateUsuario(
                        idUsaurioSeleccionado,
                        txtNombre.getText(),
                        txtApellido.getText(),
                        txtUsuario.getText(),
                        txtPassword.getText(),
                        comboPrivilegios.getSelectionModel().getSelectedItem()
                );
                if (flag) {
                    ContextualWindow.contextualWindow("information", splitPaneArticulos, "El usuario se actualizó con éxito.", "Información");
                    cleaningFields();
                }
            } else {
                ContextualWindow.contextualWindow("warning", splitPaneArticulos, "Los campos con * son necesario de completar", "Advertencia");
            }
        });
        btnDelete.setOnAction(actionEvent -> {
            boolean flag = ContextualWindow.contextualOptionWarningWindow(splitPaneArticulos, "¿Esta seguro de desactivar este usuario?\n ".concat(txtNombre.getText()),
                    "Confirmación");
            if (flag) {
                boolean flagT = usuarioService.deleteUsuario(idUsaurioSeleccionado);
                if (flagT) {
                    ContextualWindow.contextualWindow("information", splitPaneArticulos, "El usuarop recurrente se desactivó con éxito.", "Información");
                    cleaningFields();
                }

            }
        });
        btnClean.setOnAction(actionEvent -> {
            cleaningFields();
        });
        btnEye.setOnAction(actionEvent -> {
            btnEye.setTooltip(TooltipGenerator.regularTooltip(txtPassword.getText()));
        });
    }

    private void settingTable() {
        tableColumId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        tableColumNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableColumUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tableColumEstatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        tableColumPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tableColumPrivilegios.setCellValueFactory(new PropertyValueFactory<>("privilegios"));
    }

    private void fetchingDataTable() {
        usuarioList = usuarioService.getAllUsuario();
        observableList = FXCollections.observableArrayList(usuarioList);
        tableView.setItems(observableList);
        tableView.refresh();
    }

    private void selectedItem() {
        try {
            tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
                @Override
                public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuarioRe,
                                    Usuario usuarioSelected) {
                    if (tableView.getSelectionModel().getSelectedItem() != null) {
                        idUsaurioSeleccionado = usuarioSelected.getIdUsuario();
                        txtNombre.setText(usuarioSelected.getNombre());
                        txtApellido.setText(usuarioSelected.getApellido());
                        txtUsuario.setText(usuarioSelected.getUsuario());
                        txtPassword.setText(usuarioSelected.getPassword());
                        comboPrivilegios.getSelectionModel().select(usuarioSelected.getPrivilegios());
                        if (usuarioSelected.getEstatus()) {
                            JFXtogleButtonActivo.setSelected(true);
                        } else {
                            JFXtogleButtonActivo.setSelected(false);
                        }
                        btnUpdate.setDisable(false);
                        btnDelete.setDisable(false);
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
        FilteredList<Usuario> filteredData = new FilteredList<Usuario>(FXCollections.observableArrayList(usuarioList), usuario -> true);

        textFieldSearch.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(usuario -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (usuario.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (usuario.getApellido().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (usuario.getUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        }));
        SortedList<Usuario> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }

    private void cleaningFields() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
        observableList.clear();
        fetchingDataTable();
        filteringData();
        ButtonsLogic.disableButtons(btnUpdate, btnDelete);
        btnCreate.setDisable(false);
    }

    private void addingTooltips() {
        txtNombre.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtApellido.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtUsuario.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtPassword.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        comboPrivilegios.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
    }
}
