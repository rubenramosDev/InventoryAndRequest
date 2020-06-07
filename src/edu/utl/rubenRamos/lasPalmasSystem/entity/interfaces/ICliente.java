package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICliente {

    public ArrayList<Cliente> getAllCliente() throws SQLException;

    public Boolean createCliente(Cliente cliente) throws SQLException;

    public Boolean updateCliente(Cliente cliente) throws SQLException;

}
