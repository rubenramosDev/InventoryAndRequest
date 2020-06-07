package edu.utl.rubenRamos.lasPalmasSystem.utils;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import java.io.File;

public class ImageLoader {

    public static String fileChooser(Pane pane, Node node) {
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        fileChooser.setTitle("Selecciona una imagen");
        File file = fileChooser.showOpenDialog(node.getScene().getWindow());
        return loadingImage(file, pane);
    }

    public static void configureFileChooser(final FileChooser fileChooser) {
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);
    }

    public static void loadFromPath(String path, Pane pane) {
        File file = new File(path);
        loadingImage(file, pane);
    }

    public static String loadingImage(File file, Pane pane) {
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            BackgroundSize backgroundSize = new BackgroundSize(10, 10, true, true, true, false);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            Background background = new Background(backgroundImage);
            pane.setBackground(background);
            return file.getAbsolutePath();
        }
        return " ";
    }
}
