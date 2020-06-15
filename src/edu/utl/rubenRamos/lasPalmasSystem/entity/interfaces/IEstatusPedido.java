package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.EstatusAlquiler;

import java.util.ArrayList;

public interface IEstatusPedido {

    public ArrayList<EstatusAlquiler> getAllEstatusPedido();

    public ArrayList<EstatusAlquiler> searchByQuery(String query);

    public String createEstatusPedido(EstatusAlquiler estatusAlquiler);

    public String updateEstatusPedido(EstatusAlquiler estatusAlquiler);

    public String deleteEstatusPedido(Integer idEstatusPedido);
}
