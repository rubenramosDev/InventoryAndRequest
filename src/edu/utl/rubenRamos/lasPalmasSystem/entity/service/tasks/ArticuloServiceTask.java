package edu.utl.rubenRamos.lasPalmasSystem.entity.service.tasks;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.util.ArrayList;

public class ArticuloServiceTask extends Task<ObservableList<Articulo>> {


    @Override
    protected ObservableList<Articulo> call() throws Exception {
        updateProgress(0, 500);
        Thread.sleep(1000);
        updateProgress(100, 500);
        Thread.sleep(1000);
        updateProgress(200, 500);
        Thread.sleep(1000);
        updateProgress(300, 500);
        Thread.sleep(1000);
        updateProgress(400, 500);
        Thread.sleep(1000);

        ArrayList<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo(1, "nombre", 1.5, 87.5, 1, 1, "hola"));
        articulos.add(new Articulo(2, "hola", 10.0, 605.5, 5, 2, "adios"));
        articulos.add(new Articulo(3, "hey", 9.5, 96.3, 87, 3, "bonjour"));
        articulos.add(new Articulo(4, "sn", 8.7, 1000598.7, 19, 1, "ciao"));
        articulos.add(new Articulo(5, "hey", 95.6, 89865.4, 5, 2, "bell"));

        updateProgress(500, 500);
        Thread.sleep(1000);
        ObservableList<Articulo> observableList = FXCollections.observableArrayList();
        observableList.addAll(articulos);
        return observableList;
    }
}
