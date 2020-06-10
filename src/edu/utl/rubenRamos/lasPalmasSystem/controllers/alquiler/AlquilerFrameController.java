package edu.utl.rubenRamos.lasPalmasSystem.controllers.alquiler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlquilerFrameController implements Initializable {

    @FXML
    private Tab tabAdministrar;

    @FXML
    private Tab tabGrupo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        settingTabsScene();
    }

    private void settingTabsScene() {
        try {
            tabAdministrar.setContent(FXMLLoader.load(getClass().getResource("../../views/alquiler/alquiler-administrar.fxml")));
            tabGrupo.setContent(FXMLLoader.load(getClass().getResource("../../views/alquiler/alquiler-crear.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
