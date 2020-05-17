package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IProducto;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Producto;

import java.util.ArrayList;

public class ProductoDao implements IProducto {
    @Override
    public ArrayList<Producto> getAllProducto() {
        return null;
    }

    @Override
    public Producto searchProductoById(Integer idProducto) {
        return null;
    }

    @Override
    public ArrayList<Producto> searchByQuery(String query) {
        return null;
    }

    @Override
    public String createProducto(Producto producto) {
        return null;
    }

    @Override
    public String updateProducto(Producto producto) {
        return null;
    }

    @Override
    public String deleteProducto(Integer idProducto) {
        return null;
    }
}
