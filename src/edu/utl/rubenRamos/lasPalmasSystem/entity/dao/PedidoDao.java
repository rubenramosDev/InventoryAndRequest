package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IPedido;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Pedido;

import java.util.ArrayList;

public class PedidoDao implements IPedido {
    @Override
    public ArrayList<Pedido> getAllPedido() {
        return null;
    }

    @Override
    public Pedido searchPedidoById(Integer idPedido) {
        return null;
    }

    @Override
    public ArrayList<Pedido> searchByQuery(String query) {
        return null;
    }

    @Override
    public String createPedido(Pedido pedido) {
        return null;
    }

    @Override
    public String updatePedido(Pedido pedido) {
        return null;
    }

    @Override
    public String deletePedido(Integer idPedido) {
        return null;
    }
}
