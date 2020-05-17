package edu.utl.rubenRamos.lasPalmasSystem.entity.service;

import edu.utl.rubenRamos.lasPalmasSystem.entity.dao.ArticuloDao;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;


import java.util.ArrayList;
import java.util.List;

public class ArticuloService {

    private ArticuloDao articuloDao = new ArticuloDao();

    public ArrayList<Articulo> getAllArticulo() {
        return articuloDao.getAllArticulo();
    }

    public Articulo searchArticuloById(Integer idArticulo) {
        return null;
    }

    public ArrayList<Articulo> searchByQuery(String query) {
        return null;
    }

    public String createArticulo(String nombre, Double precioUnitario, Double precioFaltante, Integer cantidad, String categoriaArticulo) {
        // String response = articuloDao.createArticulo(new Articulo(nombre, precioUnitario, precioFaltante, cantidad, categoriaArticulo));
        return "";
    }

    public String updateArticulo(Articulo articulo) {
        return null;
    }

    public String deleteArticulo(Integer idArticulo) {
        return null;
    }
}
