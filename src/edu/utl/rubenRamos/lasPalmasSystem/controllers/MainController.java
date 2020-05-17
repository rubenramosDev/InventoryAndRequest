package edu.utl.rubenRamos.lasPalmasSystem.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane borderPaneMain;

    @FXML
    private Text txtInicial;

    @FXML
    private Text txtUser;

    @FXML
    private Text txtPermisos;

    @FXML
    private JFXButton btnPedidos;

    @FXML
    private JFXButton btnArticulos;

    @FXML
    private JFXButton btnCliente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addingListeners();
    }

    private void addingListeners() {
        btnArticulos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    loader("../views/articulos/frame-articulos.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void loader(String route) throws IOException {
        borderPaneMain.setCenter(FXMLLoader.load(getClass().getResource(route)));
    }


}
