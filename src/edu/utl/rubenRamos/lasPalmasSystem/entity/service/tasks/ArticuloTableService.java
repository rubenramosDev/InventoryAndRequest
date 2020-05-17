package edu.utl.rubenRamos.lasPalmasSystem.entity.service.tasks;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;


public class ArticuloTableService extends Service<ObservableList<Articulo>> {

    @Override
    protected Task createTask() {
        return new ArticuloServiceTask();
    }
}
