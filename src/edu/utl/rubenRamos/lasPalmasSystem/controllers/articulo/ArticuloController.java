package edu.utl.rubenRamos.lasPalmasSystem.controllers.articulo;

import com.jfoenix.controls.*;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.ArticuloService;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.tasks.ArticuloTableService;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import edu.utl.rubenRamos.lasPalmasSystem.utils.Validators;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArticuloController implements Initializable {

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
    private JFXComboBox<?> comboCategoria;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnCreate;
    @FXML
    private JFXButton btnLoadImage;
    @FXML
    private BorderPane borderPaneSide;

    private List<JFXTextField> doubleFields = new ArrayList<>();
    private List<JFXTextField> fields = new ArrayList<>();

    private ArticuloService articuloService = new ArticuloService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        formValitadors();
        addingListeners();
        try {
            loadTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void formValitadors() {
        doubleFields.add(txtPrecioFaltante);
        doubleFields.add(txtPrecioUnitario);
        Validators.floarValitadorList(doubleFields);
        Validators.intValitador(txtCantidad);
    }

    private void addingListeners() {
        fields.add(txtCantidad);
        fields.add(txtNombre);
        fields.add(txtPrecioFaltante);
        fields.add(txtPrecioUnitario);

        btnCreate.setOnAction(actionEvent -> {
            if (Validators.formNotNull(fields, "warning", splitPaneArticulos,
                    "Campos vacíos", "Los campos con * son obligatorios.")) {
                /*try {
                    articuloService.createArticulo(
                        txtNombre.getText(), Double.parseDouble(txtPrecioUnitario.getText()),
                        Double.parseDouble(txtPrecioFaltante.getText()), Integer.parseInt(txtCantidad.getText()), comboCategoria.getSelectionModel().select());
                }catch (NumberFormatException numberFormatException){
                            ContextualWindow.contextualWindow("error",splitPaneArticulos, "Vuelva a internarlo", "Error");
                }*/
            }
        });
        btnUpdate.setOnAction(actionEvent -> {
            if (Validators.formNotNull(fields, "warning", splitPaneArticulos,
                    "Campos vacíos", "Los campos con * son obligatorios.")) {

            }
        });
        btnDelete.setOnAction(actionEvent -> {
            ContextualWindow.contextualWindow(
                    "confirmation",
                    splitPaneArticulos, "¿Esta seguro de eliminar este artículo?\n ".concat(txtNombre.getText()),
                    "Confirmación");
        });
    }

    private void loadTable() throws IOException {
        borderPaneSide.setCenter(FXMLLoader.load(getClass().getResource("../../views/articulos/table-articulos.fxml")));
    }


}
