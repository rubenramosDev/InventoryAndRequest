package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.ICategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.JDBCConnection;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class CategoriaArticuloDao implements ICategoriaArticulo {

    @Override
    public ArrayList<CategoriaArticulo> getAllCategoriaArticulo() throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            ArrayList<CategoriaArticulo> listCategoriaArticulos = new ArrayList<>();
            String sql = "SELECT * FROM categoria_articulos ORDER BY id_categoria ASC";

            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listCategoriaArticulos.add(new CategoriaArticulo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            return listCategoriaArticulos;
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            return null;
        } finally {
            connection.close();
            JDBCConnection.closeConnection();
        }
    }

    @Override
    public Boolean createCategoriaArticulo(CategoriaArticulo categoriaArticulo) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "INSERT INTO categoria_articulos (nombre, forma) VALUES (?,?)";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, categoriaArticulo.getNombre());
            statement.setString(2, categoriaArticulo.getForma());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException exception) {
            ContextualWindow.basicContextualWindow("¡ UPS !", "La categoría ya existe");
        }
        return false;
    }

    @Override
    public Boolean updateCategoriaArticulo(CategoriaArticulo categoriaArticulo) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "Update categoria_articulos SET nombre=?, forma =? WHERE id_categoria=?";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, categoriaArticulo.getNombre());
            statement.setString(2, categoriaArticulo.getForma());
            statement.setInt(3, categoriaArticulo.getIdCategoria());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        } finally {
            connection.close();
            JDBCConnection.closeConnection();
        }
        return false;
    }

}
