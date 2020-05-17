package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.EstatusPedido;

import java.util.ArrayList;

public interface IEstatusPedido {

    public ArrayList<EstatusPedido> getAllEstatusPedido();

    public ArrayList<EstatusPedido> searchByQuery(String query);

    public String createEstatusPedido(EstatusPedido estatusPedido);

    public String updateEstatusPedido(EstatusPedido estatusPedido);

    public String deleteEstatusPedido(Integer idEstatusPedido);
}
