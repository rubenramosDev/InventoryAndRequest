package edu.utl.rubenRamos.lasPalmasSystem.utils;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    public static void startWindow(Alert.AlertType type, Stage stage, String message, String title) {
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setHeaderText(title);
        alert.getDialogPane().setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
    }


}
