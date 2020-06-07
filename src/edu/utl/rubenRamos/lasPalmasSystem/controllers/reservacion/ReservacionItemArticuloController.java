package edu.utl.rubenRamos.lasPalmasSystem.controllers.reservacion;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ReservacionItemArticuloController {

    @FXML
    private Text txtNombreArticulo;

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private JFXButton btnConfirmar;

    public ReservacionItemArticuloController reservacionItemArticuloController;

    public ReservacionItemArticuloController() {
        reservacionItemArticuloController = new ReservacionItemArticuloController();
    }

    public ReservacionItemArticuloController getReservacionItemArticuloController() {
        return reservacionItemArticuloController;
    }

    public void setReservacionItemArticuloController(ReservacionItemArticuloController reservacionItemArticuloController) {
        this.reservacionItemArticuloController = reservacionItemArticuloController;
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
