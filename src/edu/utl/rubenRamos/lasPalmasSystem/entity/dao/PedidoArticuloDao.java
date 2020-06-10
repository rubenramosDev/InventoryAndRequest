package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IPedidoArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.alquiler.AlquilerArticulo;

import java.util.ArrayList;

public class PedidoArticuloDao implements IPedidoArticulo {
    @Override
    public ArrayList<AlquilerArticulo> getAllPedidoArticulo() {
        return null;
    }

    @Override
    public AlquilerArticulo searchPedidoArticuloById(Integer idPedidoArticulo) {
        return null;
    }

    @Override
    public ArrayList<AlquilerArticulo> searchByQuery(String query) {
        return null;
    }

    @Override
    public String createPedidoArticulo(AlquilerArticulo alquilerArticulo) {
        return null;
    }

    @Override
    public String updatePedidoArticulo(AlquilerArticulo alquilerArticulo) {
        return null;
    }

    @Override
    public String deletePedidoArticulo(Integer idPedidoArticulo) {
        return null;
    }
}
