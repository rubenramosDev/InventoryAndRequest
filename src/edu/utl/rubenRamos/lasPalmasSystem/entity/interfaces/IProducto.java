package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Producto;

import java.util.ArrayList;

public interface IProducto {

    public ArrayList<Producto> getAllProducto();

    public Producto searchProductoById(Integer idProducto);

    public ArrayList<Producto> searchByQuery(String query);

    public String createProducto(Producto producto);

    public String updateProducto(Producto producto);

    public String deleteProducto(Integer idProducto);
}
