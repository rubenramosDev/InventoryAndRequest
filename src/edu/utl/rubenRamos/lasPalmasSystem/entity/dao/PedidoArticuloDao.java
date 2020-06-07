package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IPedidoArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.pedido.PedidoArticulo;

import java.util.ArrayList;

public class PedidoArticuloDao implements IPedidoArticulo {
    @Override
    public ArrayList<PedidoArticulo> getAllPedidoArticulo() {
        return null;
    }

    @Override
    public PedidoArticulo searchPedidoArticuloById(Integer idPedidoArticulo) {
        return null;
    }

    @Override
    public ArrayList<PedidoArticulo> searchByQuery(String query) {
        return null;
    }

    @Override
    public String createPedidoArticulo(PedidoArticulo pedidoArticulo) {
        return null;
    }

    @Override
    public String updatePedidoArticulo(PedidoArticulo pedidoArticulo) {
        return null;
    }

    @Override
    public String deletePedidoArticulo(Integer idPedidoArticulo) {
        return null;
    }
}
