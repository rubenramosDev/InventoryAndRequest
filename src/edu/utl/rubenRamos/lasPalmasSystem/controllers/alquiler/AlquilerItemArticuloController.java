package edu.utl.rubenRamos.lasPalmasSystem.controllers.alquiler;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class AlquilerItemArticuloController {

    @FXML
    private Text txtNombreArticulo;

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private JFXButton btnConfirmar;

    public AlquilerItemArticuloController alquilerItemArticuloController;

    public AlquilerItemArticuloController() {
        alquilerItemArticuloController = new AlquilerItemArticuloController();
    }

    public AlquilerItemArticuloController getAlquilerItemArticuloController() {
        return alquilerItemArticuloController;
    }

    public void setAlquilerItemArticuloController(AlquilerItemArticuloController alquilerItemArticuloController) {
        this.alquilerItemArticuloController = alquilerItemArticuloController;
    }

    public Text getTxtNombreArticulo() {
        return txtNombreArticulo;
    }

    public void setTxtNombreArticulo(Text txtNombreArticulo) {
        this.txtNombreArticulo = txtNombreArticulo;
    }

    public JFXButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JFXButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JFXButton getBtnConfirmar() {
        return btnConfirmar;
    }

    public void setBtnConfirmar(JFXButton btnConfirmar) {
        this.btnConfirmar = btnConfirmar;
    }
}
