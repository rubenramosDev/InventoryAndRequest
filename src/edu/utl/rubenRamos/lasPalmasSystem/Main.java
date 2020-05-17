package edu.utl.rubenRamos.lasPalmasSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/main/main.fxml"));
        primaryStage.setTitle("Sistema de gestíón - Las palmas");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinWidth(600);
        primaryStage.setMaxHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
