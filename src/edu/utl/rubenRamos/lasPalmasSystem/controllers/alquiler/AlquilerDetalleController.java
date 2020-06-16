package edu.utl.rubenRamos.lasPalmasSystem.controllers.alquiler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

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

    public void initData(ArrayList<Articulo> articulos, Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin) {
        txtNombreCliente.setText(cliente.getNombre().concat(" ").concat(cliente.getApellido()));
        txtDireccionParticular.setText(cliente.getDireccionParticular());
        txtTelefono.setText(cliente.getTelefono());


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
    }

    private void fetchingData(ArrayList<Articulo> articulos) {
        tableView.setItems(FXCollections.observableArrayList(articulos));
    }
}
