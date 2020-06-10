package edu.utl.rubenRamos.lasPalmasSystem.controllers.alquiler;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlquilerController implements Initializable {


    @FXML
    private JFXListView<Node> jfxListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fillingList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillingList() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("../../views/alquiler/alquiler-item.fxml"));
        jfxListView.getItems().add(node);
    }
}
