package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICategoriaArticulo {

    public ArrayList<CategoriaArticulo> getAllCategoriaArticulo() throws SQLException;

    public Boolean createCategoriaArticulo(CategoriaArticulo categoriaArticulo) throws SQLException;

    public Boolean updateCategoriaArticulo(CategoriaArticulo categoriaArticulo) throws SQLException;
}
