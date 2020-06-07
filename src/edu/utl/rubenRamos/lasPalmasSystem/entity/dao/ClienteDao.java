package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.ICliente;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.JDBCConnection;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao implements ICliente {
    @Override
    public ArrayList<Cliente> getAllCliente() throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            ArrayList<Cliente> listCliente = new ArrayList<>();
            String sql = "SELECT * FROM clientes ORDER BY id_cliente ASC";

            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listCliente.add(new Cliente(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                ));
            }
            return listCliente;
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            return null;
        } finally {
            connection.close();
            JDBCConnection.closeConnection();
        }
    }

    @Override
    public Boolean createCliente(Cliente cliente) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "INSERT INTO clientes (nombre, apellido, direccion_particular, ciudad, telefono, nombre_organizacion) VALUES (?, ?, ?, ?,?,?)";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccionParticular());
            statement.setString(4, cliente.getCiudad());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getNombreOrganizacion());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()).concat(String.valueOf(exception.getErrorCode())));
            return false;
        } finally {
            connection.close();
            JDBCConnection.closeConnection();
        }
        return false;
    }

    @Override
    public Boolean updateCliente(Cliente cliente) throws SQLException {
        Connection connection = JDBCConnection.getDBConnection();
        try {
            String sql = "Update clientes SET nombre=? , apellido=?, direccion_particular=?, ciudad=?, telefono=?, nombre_organizacion=? WHERE id_cliente=?";

            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccionParticular());
            statement.setString(4, cliente.getCiudad());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getNombreOrganizacion());
            statement.setInt(7, cliente.getIdCliente());

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
