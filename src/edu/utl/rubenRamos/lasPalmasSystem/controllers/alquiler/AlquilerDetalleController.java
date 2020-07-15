package edu.utl.rubenRamos.lasPalmasSystem.controllers.alquiler;

import com.jfoenix.controls.*;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.ClienteService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AlquilerDetalleController {

    @FXML
    private JFXDatePicker datePickerFechaInicio;

    @FXML
    private JFXDatePicker datePickerFechaFin;

    @FXML
    private JFXTextField txtNombreCliente;

    @FXML
    private JFXTextField txtDireccionParticular;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField txtDireccionEntrega;

    @FXML
    private JFXTextField txtFlete;

    @FXML
    private JFXTextField txtDescuento;

    @FXML
    private JFXTextArea txtNotas;

    @FXML
    private Text txtMonto;

    @FXML
    private JFXButton btnAlquilar;

    @FXML
    private TableView<Articulo> tableView;

    @FXML
    private TableColumn<Articulo, String> columnArticulo;

    @FXML
    private TableColumn<Articulo, String> columnGrupoArt;

    @FXML
    private TableColumn<Articulo, String> columnForma;

    @FXML
    private TableColumn<Articulo, String> columnCantidad;

    @FXML
    private TableColumn<Articulo, String> columnPrecio;

    @FXML
    private JFXComboBox<String> comboCliente;
    @FXML
    private JFXButton btnAddUser;

    private ArrayList<Cliente> clientes = new ArrayList<>();


    public void initData(ArrayList<Articulo> articulos, LocalDate fechaInicio, LocalDate fechaFin) {
        datePickerFechaInicio.setValue(fechaInicio);
        datePickerFechaFin.setValue(fechaFin);

        addingListeners();
        settingTable();
        fetchingData(articulos);
    }

    private void settingTable() {

        columnArticulo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnGrupoArt.setCellValueFactory(new PropertyValueFactory<>("categoriArticuloNameTable"));
        columnForma.setCellValueFactory(new PropertyValueFactory<>("categoriaArticuloFormaTable"));
        columnCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
    }

    private void addingListeners() {
        btnAlquilar.setOnAction(actionEvent -> {

        });
//
//        btnAddUser.setOnAction(actionEvent -> {
//            addingUser();
//        });

    }

    private void fetchingData(ArrayList<Articulo> articulos) {
        tableView.setItems(FXCollections.observableArrayList(articulos));
    }

    private void fillingComboBox() {
        ClienteService clienteService = new ClienteService();
        clientes = clienteService.getAllCliente();
        ArrayList<String> names = new ArrayList<>();

        comboCliente.getItems().addAll(names);
        comboCliente.getSelectionModel().select(0);

        int i = 1;
        for (Cliente cliente : clientes) {
            String nombre = String.valueOf(i).concat(" ").concat(cliente.getNombre().concat(" ").concat(cliente.getApellido()));
            names.add(nombre);
            i++;
        }

        JFXAutoCompletePopup<String> autoCompletePopup = new JFXAutoCompletePopup<>();
        autoCompletePopup.getSuggestions().addAll(names);

        autoCompletePopup.setSelectionHandler(event -> {
            comboCliente.setValue(event.getObject());
        });

        TextField editor = comboCliente.getEditor();
        editor.textProperty().addListener(observable -> {
            autoCompletePopup.filter(item -> item.toLowerCase().contains(editor.getText().toLowerCase()));

            if (autoCompletePopup.getFilteredSuggestions().isEmpty() || comboCliente.showingProperty().get()) {
                autoCompletePopup.hide();
            } else {
                autoCompletePopup.show(editor);
            }
        });
    }


    private void addingUser() {
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

}
