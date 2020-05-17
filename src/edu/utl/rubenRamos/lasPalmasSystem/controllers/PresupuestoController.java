package edu.utl.rubenRamos.lasPalmasSystem.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PresupuestoController implements Initializable {
    @FXML
    private BorderPane borderPaneTabla;

    @FXML
    private JFXListView<Node> JFXListViewPresupuesto;

    @FXML
    private JFXButton btnRefresh;

    @FXML
    private JFXButton btnPedido;

    @FXML
    private JFXButton btnCalcular;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        localLoader();
    }

    private void localLoader() {
        try {
            borderPaneTabla.setCenter(FXMLLoader.load(getClass().getResource("../views/articulos/table-articulos.fxml")));
            JFXListViewPresupuesto.getItems().add(FXMLLoader.load(getClass().getResource("../views/presupuesto/presupuesto-item.fxml")));


            //cell.set


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
