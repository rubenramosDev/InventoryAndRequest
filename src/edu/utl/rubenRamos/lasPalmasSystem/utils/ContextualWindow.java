package edu.utl.rubenRamos.lasPalmasSystem.utils;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class ContextualWindow {

    public static void contextualWindow(String windowType, Node window, String message, String title) {
        Stage stage = (Stage) window.getScene().getWindow();
        Alert.AlertType type = null;
        switch (windowType) {
            case "confirmation":
                type = Alert.AlertType.CONFIRMATION;
                startWindow(type, stage, message, title);
                break;
            case "information":
                type = Alert.AlertType.INFORMATION;
                startWindow(type, stage, message, title);
                break;
            case "error":
                type = Alert.AlertType.ERROR;
                startWindow(type, stage, message, title);
                break;
            case "warning":
                type = Alert.AlertType.WARNING;
                startWindow(type, stage, message, title);
                break;
        }


    }

    public static void basicContextualWindow(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void startWindow(Alert.AlertType type, Stage stage, String message, String title) {
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setHeaderText(title);
        alert.getDialogPane().setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
    }

    public static Boolean contextualOptionWarningWindow(Node window, String message, String title) {
        Stage stage = (Stage) window.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.WARNING, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setHeaderText(title);
        alert.getDialogPane().setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result != null) {
            if (result.get() == ButtonType.OK) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void contextualWindowException(Exception exception) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("¡ Ups, ocurrió un error inesperado !");
        alert.setContentText("Vuelva a interntar el procedimiento.\nEn caso de repetirse pongase en contacto con soporte");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        String exceptionText = stringWriter.toString();

        Label label = new Label("Error:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    public static boolean contextualWindowDuplicatedEntry(String tipo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¡".concat(tipo).concat(" que intenta registrar ya existe o fue eliminado !"));
        alert.setContentText("¿ Desea reactivar el artículo ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result != null) {
            if (result.get() == ButtonType.OK) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
