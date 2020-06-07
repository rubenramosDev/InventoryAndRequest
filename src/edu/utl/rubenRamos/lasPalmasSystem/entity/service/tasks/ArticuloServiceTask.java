package edu.utl.rubenRamos.lasPalmasSystem.entity.service.tasks;

import com.mysql.jdbc.Statement;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.JDBCConnection;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloServiceTask extends Task<ObservableList<Articulo>> {

    @Override
    protected ObservableList<Articulo> call() throws Exception {
        int j = 0;
        for (int i = 0; i < 5; i++) {
            updateProgress(j, 500);
            Thread.sleep(1);
            j = j + 100;
        }

        ArrayList<Articulo> listArticulos = getAllArticulos();
        updateProgress(500, 500);
        ObservableList<Articulo> observableList = FXCollections.observableArrayList(listArticulos);
        return observableList;
    }

    private ArrayList<Articulo> getAllArticulos() throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            ArrayList<Articulo> listArticulos = new ArrayList<>();
            String sql = "SELECT ar.id_articulo, ar.nombre, ar.precio_unitario, ar.precio_faltante, ar.cantidad, ar.imagen_path, ca.id_categoria, ca.nombre, ca.forma FROM articulos ar INNER JOIN categoria_articulos ca on ar.id_grupo_articulo = ca.id_categoria WHERE ar.estatus = true";

            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Articulo articulo = null;
                listArticulos.add(articulo = new Articulo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8),
                        resultSet.getString(9)
                ));
                articulo.setCategoriArticuloNameTable(articulo.getCategoriaArticulo().getNombre());
                articulo.setCategoriaArticuloFormaTable(articulo.getCategoriaArticulo().getForma());
            }
            return listArticulos;
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            return null;
        } finally {
            connection.close();
            JDBCConnection.closeConnection();
        }
    }
}
