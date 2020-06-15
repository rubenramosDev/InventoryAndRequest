package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IUsuario;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.JDBCConnection;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Usuario;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class UsuarioDao implements IUsuario {

    public ArrayList<Usuario> getAllUsuario() throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            ArrayList<Usuario> listUsuario = new ArrayList<>();
            String sql = "SELECT * FROM usuarios ORDER BY id_usuario ASC";

            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listUsuario.add(new Usuario(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getBoolean(7)
                ));
            }
            return listUsuario;
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            return null;
        } finally {
            connection.close();
            JDBCConnection.closeConnection();
        }
    }

    public Boolean createUsuario(Usuario usuario) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "INSERT INTO usuarios (nombre, apellido, usuario, contrasenia, privilegio) VALUES (?, ?, ?, ?,?)";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getUsuario());
            statement.setString(4, usuario.getPassword());
            statement.setString(5, usuario.getPrivilegios());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmación");
                alert.setHeaderText("¡ El nombre de usuario que intenta registrar ya existe, este campo no se puede repetir !");
                alert.setContentText("¿ Desea reactivar el usuario ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result != null) {
                    if (result.get() == ButtonType.OK) {
                        boolean flag = activeUsuario(0, usuario.getUsuario());
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

    public Boolean updateUsuario(Usuario usuario) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "Update usuarios SET nombre=? , apellido=?, usuario=?, contrasenia=?, privilegio=? WHERE id_usuario=?";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getUsuario());
            statement.setString(4, usuario.getPassword());
            statement.setString(5, usuario.getPrivilegios());
            statement.setInt(6, usuario.getIdUsuario());

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

    public Boolean activeUsuario(Integer idUsuario, String username) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            if (idUsuario == 0) {
                String sql = "Update usuarios SET estatus=true WHERE usuario=?";
                PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
                statement.setString(1, username);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
            } else {
                String sql = "Update usuarios SET estatus=true WHERE id_usuario=?";

                PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
                statement.setInt(1, idUsuario);

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

    public Boolean deleteUsuario(Integer idArticulo) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "Update usuarios SET estatus=false WHERE id_usuario=?";

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
