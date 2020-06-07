package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import com.mysql.jdbc.PreparedStatement;
import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.JDBCConnection;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class ArticuloDao implements IArticulo {

    @Override
    public Boolean createArticulo(Articulo articulo) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "INSERT INTO articulos (nombre, precio_unitario, precio_faltante, cantidad, imagen_path, estatus, id_grupo_articulo) VALUES (?, ?, ?, ?,?,?,?)";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, articulo.getNombre());
            statement.setDouble(2, articulo.getPrecioUnitario());
            statement.setDouble(3, articulo.getPrecioFaltante());
            statement.setInt(4, articulo.getCantidad());
            statement.setString(5, articulo.getPathImage());
            statement.setBoolean(6, true);
            statement.setInt(7, articulo.getCategoriaArticulo().getIdCategoria());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmación");
                alert.setHeaderText("¡ El artículo que intenta registrar ya existe o fue eliminado !");
                alert.setContentText("¿ Desea reactivar el artículo ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result != null) {
                    if (result.get() == ButtonType.OK) {
                        boolean flag = activeArticulo(0, articulo.getNombre());
                        return (flag) ? true : false;
                    }
                } else {
                    return false;
                }
            } else {
                ContextualWindow.contextualWindowException(exception);
                System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()).concat(String.valueOf(exception.getErrorCode())));
                return false;
            }
        } finally {
            connection.close();
            JDBCConnection.closeConnection();
        }
        return false;
    }

    @Override
    public Boolean updateArticulo(Articulo articulo) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "Update articulos SET nombre=? , precio_unitario=?, precio_faltante=?, cantidad=?, imagen_path=?, id_grupo_articulo=? WHERE id_articulo=?";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, articulo.getNombre());
            statement.setDouble(2, articulo.getPrecioUnitario());
            statement.setDouble(3, articulo.getPrecioFaltante());
            statement.setInt(4, articulo.getCantidad());
            statement.setString(5, articulo.getPathImage());
            statement.setInt(6, articulo.getCategoriaArticulo().getIdCategoria());
            statement.setInt(7, articulo.getIdArticulo());

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

    @Override
    public Boolean activeArticulo(Integer idArticulo, String nombre) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            if (idArticulo == 0) {
                String sql = "Update articulos SET estatus=true WHERE nombre=?";
                PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
                statement.setString(1, nombre);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
            } else {
                String sql = "Update articulos SET estatus=true WHERE id_articulo=?";

                PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
                statement.setInt(1, idArticulo);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
            }

        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        } finally {
            connection.close();
            JDBCConnection.closeConnection();
        }
        return true;
    }

    @Override
    public Boolean deleteArticulo(Integer idArticulo) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "Update articulos SET estatus=false WHERE id_articulo=?";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, idArticulo);

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
        return true;
    }
}
