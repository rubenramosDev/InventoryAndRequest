package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.ClienteRecurrente;

import java.util.ArrayList;

public interface IClienteRecurrente {

    public ArrayList<ClienteRecurrente> getAllClienteRecurrente();

    public String createClienteRecurrente(ClienteRecurrente clienteRecurrente);

    public String updateClienteRecurrente(ClienteRecurrente clienteRecurrente);

    public String deleteClienteRecurrente(Integer clienteRecurrente);
}
