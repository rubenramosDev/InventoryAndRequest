package edu.utl.rubenRamos.lasPalmasSystem.entity.service;

import edu.utl.rubenRamos.lasPalmasSystem.entity.dao.ClienteDao;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteService {

    private ClienteDao clienteDao = new ClienteDao();

    public ArrayList<Cliente> getAllCliente() {
        try {
            return clienteDao.getAllCliente();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public Boolean createCliente(String nombre, String apellido, String direccionParticular, String
            ciudad, String telefono, String nombreOrganizacion) {
        try {
            return clienteDao.createCliente(new Cliente(nombre, apellido, direccionParticular, ciudad, telefono, nombreOrganizacion));
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }

    public Boolean updateCliente(Integer idCliente, String nombre, String apellido, String
            direccionParticular, String ciudad, String telefono, String nombreOrganizacion) {
        try {
            return clienteDao.updateCliente(new Cliente(idCliente, nombre, apellido, direccionParticular, ciudad, telefono, nombreOrganizacion));
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }

}
