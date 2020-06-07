package edu.utl.rubenRamos.lasPalmasSystem.controllers.usuario;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioFrameController implements Initializable {

    @FXML
    private BorderPane borderPaneUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            borderPaneUsuarios.setCenter(FXMLLoader.load(getClass().getResource("../../views/usuarios/usuario.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
