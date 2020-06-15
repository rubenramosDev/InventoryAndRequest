package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.AlquilerArticulo;

import java.util.ArrayList;

public interface IPedidoArticulo {

    public ArrayList<AlquilerArticulo> getAllPedidoArticulo();

    public AlquilerArticulo searchPedidoArticuloById(Integer idPedidoArticulo);

    public ArrayList<AlquilerArticulo> searchByQuery(String query);

    public String createPedidoArticulo(AlquilerArticulo alquilerArticulo);

    public String updatePedidoArticulo(AlquilerArticulo alquilerArticulo);

    public String deletePedidoArticulo(Integer idPedidoArticulo);}
