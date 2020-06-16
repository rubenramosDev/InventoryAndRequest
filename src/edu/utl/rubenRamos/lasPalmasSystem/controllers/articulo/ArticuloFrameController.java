package edu.utl.rubenRamos.lasPalmasSystem.controllers.articulo;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArticuloFrameController implements Initializable {

    @FXML
    private Tab tabArticulos;

    @FXML
    private Tab tabGrupoArticulos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        settingTabsScene();
    }

    private void settingTabsScene() {
        try {
            tabArticulos.setContent(FXMLLoader.load(getClass().getResource("../../views/articulos/articulos.fxml")));
            tabGrupoArticulos.setContent(FXMLLoader.load(getClass().getResource("../../views/articulos/articulos-grupo.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
