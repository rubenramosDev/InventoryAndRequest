package edu.utl.rubenRamos.lasPalmasSystem.controllers.cliente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.utl.rubenRamos.lasPalmasSystem.entity.service.ClienteService;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import edu.utl.rubenRamos.lasPalmasSystem.utils.Validators;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/*Single form to create a cliente from alquiler*/
public class ClienteCrearController implements Initializable {

    @FXML
    private AnchorPane anchorPaneCliente;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtApellido;

    @FXML
    private JFXTextField txtDireccion;

    @FXML
    private JFXTextField txtCiudad;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField txtOrganizacion;

    @FXML
    private JFXButton btnCreate;

    @FXML
    private JFXButton btnClean;

    private ClienteService clienteService = new ClienteService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addingListeners();
    }

    private void addingListeners() {
        btnCreate.setOnAction(actionEvent -> {
            creatingUser();
        });
        btnClean.setOnAction(actionEvent -> {
            cleaningFields();
        });
    }

    private void creatingUser() {
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
                        ContextualWindow.contextualWindow("information", anchorPaneCliente, "El cliente se agregó con éxito.", "Información");
                        cleaningFields();
                    }
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                    ContextualWindow.contextualWindow("error", anchorPaneCliente, "Vuelva a internarlo", "Error");
                }
            } else {
                ContextualWindow.contextualWindow("warning", anchorPaneCliente, "Los campos con * son necesario de completar", "Advertencia");
            }
        });
    }

    private void cleaningFields() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtOrganizacion.setText("");
        txtTelefono.setText("");
        txtCiudad.setText("");
    }

}
