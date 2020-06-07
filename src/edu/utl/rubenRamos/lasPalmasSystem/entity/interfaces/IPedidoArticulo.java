package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.pedido.PedidoArticulo;

import java.util.ArrayList;

public interface IPedidoArticulo {

    public ArrayList<PedidoArticulo> getAllPedidoArticulo();

    public PedidoArticulo searchPedidoArticuloById(Integer idPedidoArticulo);

    public ArrayList<PedidoArticulo> searchByQuery(String query);

    public String createPedidoArticulo(PedidoArticulo pedidoArticulo);

    public String updatePedidoArticulo(PedidoArticulo pedidoArticulo);

    public String deletePedidoArticulo(Integer idPedidoArticulo);}
