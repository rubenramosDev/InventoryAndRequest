package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;

import java.util.ArrayList;

public interface IArticulo {

    public ArrayList<Articulo> getAllArticulo();

    public Articulo searchArticuloById(Integer idArticulo);

    public ArrayList<Articulo> searchByQuery(String query);

    public String createArticulo(Articulo articulo);

    public String updateArticulo(Articulo articulo);

    public String deleteArticulo(Integer idArticulo);
}
