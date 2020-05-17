package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;

import java.util.ArrayList;

public class ArticuloDao implements IArticulo {
    @Override
    public ArrayList<Articulo> getAllArticulo() {
        ArrayList<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo(1, "nombre", 1.5, 87.5, 1, 1, "hola"));
        articulos.add(new Articulo(2, "hola", 10.0, 605.5, 5, 2, "adios"));
        articulos.add(new Articulo(3, "hey", 9.5, 96.3, 87, 3, "bonjour"));
        articulos.add(new Articulo(4, "sn", 8.7, 1000598.7, 19, 1, "ciao"));
        articulos.add(new Articulo(5, "hey", 95.6, 89865.4, 5, 2, "bell"));
        return articulos;
    }

    @Override
    public Articulo searchArticuloById(Integer idArticulo) {
        return null;
    }

    @Override
    public ArrayList<Articulo> searchByQuery(String query) {
        return null;
    }

    @Override
    public String createArticulo(Articulo articulo) {
        return null;
    }

    @Override
    public String updateArticulo(Articulo articulo) {
        return null;
    }

    @Override
    public String deleteArticulo(Integer idArticulo) {
        return null;
    }
}
