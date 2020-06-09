package edu.utl.rubenRamos.lasPalmasSystem.utils;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {

    public static void intValitador(JFXTextField field) {
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    field.setText(s.replaceAll("[^\\d]", ""));
                }
            }
        });
    }



    public static void intValitadorList(List<JFXTextField> fields) {
        for (JFXTextField field : fields) {
            field.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    if (!t1.matches("\\d*")) {
                        field.setText(s.replaceAll("[^\\d]", ""));
                    }
                }
            });
        }
    }

    public static void doubleValidator(JFXTextField field) {
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try {
                    if (!t1.matches("\\d*(\\.\\d*)?")) {
                        field.setText(s.replaceAll("", ""));
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        });
    }

    public static void doubleValitadorList(List<JFXTextField> fields) {
        for (JFXTextField field : fields) {
            field.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    try {
                        if (!t1.matches("\\d*(\\.\\d*)?")) {
                            field.setText(s.replaceAll("", ""));
                        }
                    } catch (Exception e) {
                        System.out.println("error");
                    }
                }
            });
        }
    }

    public static boolean formNotNull(List<JFXTextField> fields) {
        for (JFXTextField field : fields) {
            if (field.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
