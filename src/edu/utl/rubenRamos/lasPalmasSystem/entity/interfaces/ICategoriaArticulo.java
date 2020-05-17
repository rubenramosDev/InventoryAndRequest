package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;

import java.util.ArrayList;

public interface ICategoriaArticulo {

    public ArrayList<CategoriaArticulo> getAllCategoriaArticulo();

    public String createCategoriaArticulo(CategoriaArticulo categoriaArticulo);

    public String updateCategoriaArticulo(CategoriaArticulo categoriaArticulo);

    public String deleteCategoriaArticulo(Integer idCategoriaArticulo);
}
