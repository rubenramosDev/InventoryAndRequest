package edu.utl.rubenRamos.lasPalmasSystem.utils;

import com.jfoenix.controls.JFXButton;

public class ButtonsLogic {

    public static void disableButtons(JFXButton btnUpdate, JFXButton btnDelete) {
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    public static void enableButtons(JFXButton btnCreate, JFXButton btnUpdate, JFXButton btnDelete){
        btnCreate.setDisable(true);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
    }

}
