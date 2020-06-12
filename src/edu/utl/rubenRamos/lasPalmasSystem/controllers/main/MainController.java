package edu.utl.rubenRamos.lasPalmasSystem.controllers.main;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
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
    private JFXButton btnAlquiler;

    @FXML
    private JFXButton btnArticulos;

    @FXML
    private JFXButton btnCliente;

    @FXML
    private JFXButton btnReportes;

    @FXML
    private JFXButton btnUsuarios;

    @FXML
    private SVGPath svgAlquilar;
    @FXML
    private SVGPath svgHome;
    @FXML
    private SVGPath svgArticulos;
    @FXML
    private SVGPath svgClientes;
    @FXML
    private SVGPath svgReportes;
    @FXML
    private SVGPath svgUsuarios;

    private JFXButton selectedItem;
    private JFXButton previousSelectedItem;

    /*
    Home,Presupuesto, Alquilar, Articulos, Clientes, Reportes, Usuarios
    * */
    String[] svgImages = new String[7];
    SVGPath actual = new SVGPath();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addingListeners();
        svgImages[0] = "M12 9.185l7 6.514v6.301h-14v-6.301l7-6.514zm0-2.732l-9 8.375v9.172h18v-9.172l-9-8.375zm2 14.547h-4v-6h4v6zm10-8.852l-1.361 1.465-10.639-9.883-10.639 9.868-1.361-1.465 12-11.133 12 11.148z";
        svgImages[1] = "M6 12h10v1h-10v-1zm7.816-3h-7.816v1h9.047c-.45-.283-.863-.618-1.231-1zm-7.816-2h6.5c-.134-.32-.237-.656-.319-1h-6.181v1zm13 3.975v2.568c0 4.107-6 2.457-6 2.457s1.518 6-2.638 6h-7.362v-20h9.5c.312-.749.763-1.424 1.316-2h-12.816v24h10.189c3.163 0 9.811-7.223 9.811-9.614v-3.886c-.623.26-1.297.421-2 .475zm4-6.475c0 2.485-2.015 4.5-4.5 4.5s-4.5-2.015-4.5-4.5 2.015-4.5 4.5-4.5 4.5 2.015 4.5 4.5zm-2.156-.882l-.696-.696-2.116 2.169-.992-.941-.696.697 1.688 1.637 2.812-2.866z";
        svgImages[2] = "M24 2v22h-24v-22h3v1c0 1.103.897 2 2 2s2-.897 2-2v-1h10v1c0 1.103.897 2 2 2s2-.897 2-2v-1h3zm-2 6h-20v14h20v-14zm-2-7c0-.552-.447-1-1-1s-1 .448-1 1v2c0 .552.447 1 1 1s1-.448 1-1v-2zm-14 2c0 .552-.447 1-1 1s-1-.448-1-1v-2c0-.552.447-1 1-1s1 .448 1 1v2zm1 11.729l.855-.791c1 .484 1.635.852 2.76 1.654 2.113-2.399 3.511-3.616 6.106-5.231l.279.64c-2.141 1.869-3.709 3.949-5.967 7.999-1.393-1.64-2.322-2.686-4.033-4.271z";
        svgImages[3] = "M18.496 24h-.001c-.715 0-1.5-.569-1.5-1.5v-8.5s-1.172-.003-2.467 0c.802-6.996 3.103-14 4.66-14 .447 0 .804.357.807.851.01 1.395.003 16.612.001 21.649 0 .828-.672 1.5-1.5 1.5zm-11.505-12.449c0-.691-.433-.917-1.377-1.673-.697-.56-1.177-1.433-1.088-2.322.252-2.537.862-7.575.862-7.575h.6v6h1.003l.223-6h.607l.173 6h1.003l.242-6h.562l.199 6h1.003v-6h.549s.674 5.005.951 7.55c.098.902-.409 1.792-1.122 2.356-.949.751-1.381.967-1.381 1.669v10.925c0 .828-.673 1.5-1.505 1.5-.831 0-1.504-.672-1.504-1.5v-10.93z";
        svgImages[4] = "M10.119 16.064c2.293-.53 4.427-.994 3.394-2.946-3.147-5.941-.835-9.118 2.488-9.118 3.388 0 5.643 3.299 2.488 9.119-1.065 1.964 1.149 2.427 3.393 2.946 1.985.458 2.118 1.428 2.118 3.107l-.003.828h-1.329c0-2.089.083-2.367-1.226-2.669-1.901-.438-3.695-.852-4.351-2.304-.239-.53-.395-1.402.226-2.543 1.372-2.532 1.719-4.726.949-6.017-.902-1.517-3.617-1.509-4.512-.022-.768 1.273-.426 3.479.936 6.05.607 1.146.447 2.016.206 2.543-.66 1.445-2.472 1.863-4.39 2.305-1.252.29-1.172.588-1.172 2.657h-1.331c0-2.196-.176-3.406 2.116-3.936zm-10.117 3.936h1.329c0-1.918-.186-1.385 1.824-1.973 1.014-.295 1.91-.723 2.316-1.612.212-.463.355-1.22-.162-2.197-.952-1.798-1.219-3.374-.712-4.215.547-.909 2.27-.908 2.819.015.935 1.567-.793 3.982-1.02 4.982h1.396c.44-1 1.206-2.208 1.206-3.9 0-2.01-1.312-3.1-2.998-3.1-2.493 0-4.227 2.383-1.866 6.839.774 1.464-.826 1.812-2.545 2.209-1.49.345-1.589 1.072-1.589 2.334l.002.618z";
        svgImages[5] = "M13 20.002h2v3.998h-2v-3.998zm-6.902 3.998h2.627l3.42-3.998h-2.633l-3.414 3.998zm9.773-3.998l3.42 3.998h2.627l-3.414-3.998h-2.633zm8.129-17.01c0 .876-.399 1.654-1 2.2v12.808h-18.984v-4h-4.016c.854-1.333 1.016-2.932 1.016-5.456v-5.183c0-2.062 1.322-3.292 2.953-3.339-.017-.031 16.996-.02 17.031-.02 1.657 0 3 1.333 3 2.99zm-18.939.021c0-.551-.448-1-1-1-.747 0-1.061.599-1.061 1.348v5.183c0 1.583 0 2.442-.229 3.458h1.244v-7.989c.552 0 1.046-.449 1.046-1zm15.955 2.987h-15.016v10.002h15.016v-10.002zm-.016-4h-14.124c.255.699.238 1.339-.001 2.002h14.125c1.303 0 1.345-2.002 0-2.002zm-10.666 12c1.307-2.344 2.214-3.548 3.454-4.63l-.161-.37c-1.503.935-2.312 1.64-3.535 3.028-.651-.464-1.018-.678-1.597-.958l-.495.458c.991.918 1.528 1.523 2.334 2.472zm8.666-5h-4v1h4v-1zm0 2h-4v1h4v-1zm0 2h-4v1h4v-1z";
        svgImages[6] = "M16 2c3.309 0 6 2.691 6 6s-2.691 6-6 6-6-2.691-6-6 2.691-6 6-6zm0-2c-4.418 0-8 3.582-8 8s3.582 8 8 8 8-3.582 8-8-3.582-8-8-8zm-5.405 16.4l-1.472 1.6h-3.123v2h-2v2h-2v-2.179l5.903-5.976c-.404-.559-.754-1.158-1.038-1.795l-6.865 6.95v5h6v-2h2v-2h2l2.451-2.663c-.655-.249-1.276-.562-1.856-.937zm7.405-11.4c.551 0 1 .449 1 1s-.449 1-1 1-1-.449-1-1 .449-1 1-1zm0-1c-1.104 0-2 .896-2 2s.896 2 2 2 2-.896 2-2-.896-2-2-2z";
    }

    private void addingListeners() {
        btnArticulos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    selectedItem(btnArticulos);

                    fillingSvg(svgArticulos, 3);
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
                    fillingSvg(svgClientes, 4);
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
                    fillingSvg(svgUsuarios, 6);
                    selectedItem(btnUsuarios);
                    loader("../../views/usuarios/usuario-frame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        btnAlquiler.setOnAction(actionEvent -> {
            try {
                actual.setContent(svgAlquilar.getContent());
                fillingSvg(svgAlquilar, 2);
                selectedItem(btnAlquiler);
                loader("../../views/alquiler/alquiler-frame.fxml");
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
                refillingSvg(selectedItem);
            }
        } else {
            button.getStyleClass().add("sidebar-button-selected");
            selectedItem = button;
        }
    }

    private void fillingSvg(SVGPath lambdaSvg, Integer position) {
        Color color = new Color(1, 1, 1, 1);
        lambdaSvg.setContent(svgImages[position]);
        lambdaSvg.setFill(color);
    }

    private void refillingSvg(JFXButton selectedItem) {
        svgAlquilar.setContent(actual.getContent());

    }
}
