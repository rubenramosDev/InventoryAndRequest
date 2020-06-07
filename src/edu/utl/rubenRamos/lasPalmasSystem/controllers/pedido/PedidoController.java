package edu.utl.rubenRamos.lasPalmasSystem.controllers.pedido;

import com.jfoenix.controls.*;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ButtonsLogic;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ImageLoader;
import edu.utl.rubenRamos.lasPalmasSystem.utils.TooltipGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class PedidoController implements Initializable {

    @FXML
    private AnchorPane estees;

    @FXML
    private JFXDatePicker datePickerFechaInicio;

    @FXML
    private JFXDatePicker datePickerFechaFin;

    @FXML
    private JFXButton btnConsultar;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField txtDireccionParticular;

    @FXML
    private JFXTextField txtDireccionEntrega;

    @FXML
    private JFXTextField txtFlete;

    @FXML
    private JFXTextArea textAreaNotas;

    @FXML
    private ScrollPane donas;

    @FXML
    private JFXListView<?> ListViewDetallePedido;

    @FXML
    private Text txtTotal;

    @FXML
    private JFXButton btnGenerarPedido;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField textFieldSearch;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tableColumId;

    @FXML
    private TableColumn<?, ?> tableColumNombre;

    @FXML
    private TableColumn<?, ?> tableColumPrecioUnitario;

    @FXML
    private TableColumn<?, ?> tableColumDisponibles;
    @FXML
    private TableColumn<?, ?> tableColumCantidad1;
    @FXML
    private TableColumn<?, ?> tableColumEnPrestamo;
    @FXML
    private TableColumn<?, ?> tableColumFechaInicio;
    @FXML
    private TableColumn<?, ?> tableColumFechaTermino;
    @FXML
    private TableColumn<?, ?> tableColumCantidadTotal;
    @FXML
    private TableColumn<?, ?> tableColumPrecioFaltante;

    @FXML
    private TableColumn<?, ?> tableColumCategoria;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addingTooltips();
        cleaningFields();
        settingTable();
        initData();
    }

    private void initData() {
        settingDateFormatter(datePickerFechaFin);
        settingDateFormatter(datePickerFechaInicio);
    }

    private void addingListeners() {
        btnConsultar.setOnAction(actionEvent -> {
            Date date = (Date) datePickerFechaInicio.getUserData();
        });
    }

    private void settingTable() {
        tableColumId.setCellValueFactory(new PropertyValueFactory<>("idArticulo"));
        tableColumNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        tableColumPrecioFaltante.setCellValueFactory(new PropertyValueFactory<>("precioFaltante"));
        tableColumCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriArticuloNameTable"));
        /*tableColumDisponibles
                tableColumCantidad1
        tableColumEnPrestamo
                tableColumFechaInicio
        tableColumFechaTermino
                tableColumCantidadTotal*/
    }


    private void addingTooltips() {
        txtNombre.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtDireccionEntrega.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtDireccionParticular.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        txtTelefono.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        datePickerFechaFin.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
        datePickerFechaInicio.setTooltip(TooltipGenerator.regularTooltip("Campo obligatorio."));
    }

    private void cleaningFields() {
        txtNombre.setText("");
        txtDireccionEntrega.setText("");
        txtDireccionParticular.setText("");
        txtTelefono.setText("");
        datePickerFechaFin.setPromptText("");
        datePickerFechaInicio.setPromptText("");
    }

    private void settingDateFormatter(JFXDatePicker datePicker) {
        datePicker.setConverter(new StringConverter<LocalDate>() {
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

}
