package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IEstatusPedido;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.alquiler.EstatusAlquiler;

import java.util.ArrayList;

public class EstatusPedidoDao implements IEstatusPedido {

    @Override
    public ArrayList<EstatusAlquiler> getAllEstatusPedido() {
        return null;
    }

    @Override
    public ArrayList<EstatusAlquiler> searchByQuery(String query) {
        return null;
    }

    @Override
    public String createEstatusPedido(EstatusAlquiler estatusAlquiler) {
        return null;
    }

    @Override
    public String updateEstatusPedido(EstatusAlquiler estatusAlquiler) {
        return null;
    }

    @Override
    public String deleteEstatusPedido(Integer idEstatusPedido) {
        return null;
    }
}
