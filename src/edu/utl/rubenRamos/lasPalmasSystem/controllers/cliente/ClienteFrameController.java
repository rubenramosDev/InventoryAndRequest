package edu.utl.rubenRamos.lasPalmasSystem.controllers.cliente;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClienteFrameController implements Initializable {

    @FXML
    private BorderPane borderPaneClientes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            borderPaneClientes.setCenter(FXMLLoader.load(getClass().getResource("../../views/cliente/cliente.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
