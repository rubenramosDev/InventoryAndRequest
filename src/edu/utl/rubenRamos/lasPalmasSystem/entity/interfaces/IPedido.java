package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.pedido.Pedido;

import java.util.ArrayList;

public interface IPedido {

    public ArrayList<Pedido> getAllPedido();

    public Pedido searchPedidoById(Integer idPedido);

    public ArrayList<Pedido> searchByQuery(String query);

    public String createPedido(Pedido pedido);

    public String updatePedido(Pedido pedido);

    public String deletePedido(Integer idPedido);
}
