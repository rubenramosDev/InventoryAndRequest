package edu.utl.rubenRamos.lasPalmasSystem.controllers.main;

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
    private JFXButton btnPresupuesto1;

    @FXML
    private JFXButton btnPresupuesto;

    @FXML
    private JFXButton btnPedidos;

    @FXML
    private JFXButton btnReservaciones;

    @FXML
    private JFXButton btnArticulos;

    @FXML
    private JFXButton btnCliente;

    @FXML
    private JFXButton btnReportes;

    @FXML
    private JFXButton btnUsuarios;

    private JFXButton selectedItem;
    private JFXButton previousSelectedItem;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addingListeners();
    }

    private void addingListeners() {
        btnArticulos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    selectedItem(btnArticulos);
                    loader("../../views/articulos/frame-articulos.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    selectedItem(btnCliente);
                    loader("../../views/cliente/cliente-frame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnUsuarios.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {

                    selectedItem(btnUsuarios);
                    loader("../../views/usuarios/usuario-frame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnPedidos.setOnAction(actionEvent -> {
            try {
                selectedItem(btnPedidos);
                loader("../../views/pedidos/pedidos.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnReservaciones.setOnAction(actionEvent -> {
            try {
                selectedItem(btnReservaciones);
                loader("../../views/reservaciones/reservaciones-frame.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void loader(String route) throws IOException {
        borderPaneMain.setCenter(FXMLLoader.load(getClass().getResource(route)));
    }

    private void selectedItem(JFXButton button) {
        if (selectedItem != null) {
            if (button != selectedItem) {
                button.getStyleClass().add("sidebar-button-selected");
                selectedItem.getStyleClass().remove(3);
                selectedItem = button;
            }
        } else {
            button.getStyleClass().add("sidebar-button-selected");
            selectedItem = button;
        }
    }
}
