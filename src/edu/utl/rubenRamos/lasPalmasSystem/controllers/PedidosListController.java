package edu.utl.rubenRamos.lasPalmasSystem.controllers;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PedidosListController implements Initializable {


    @FXML
    private JFXListView<Node> JFXListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            JFXListView.getItems().add(FXMLLoader.load(getClass().getResource("../views/reservacion-item.fxml")));
            JFXListView.getItems().add(FXMLLoader.load(getClass().getResource("../views/reservacion-item.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
