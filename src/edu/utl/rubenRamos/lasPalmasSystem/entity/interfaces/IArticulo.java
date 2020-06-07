package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IArticulo {

    public Boolean createArticulo(Articulo articulo) throws SQLException;

    public Boolean updateArticulo(Articulo articulo) throws SQLException;

    public Boolean activeArticulo(Integer idArticulo, String nombre) throws SQLException;

    public Boolean deleteArticulo(Integer idArticulo) throws SQLException;
}
