package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface IArticulo {

    public ArrayList<Articulo> getByDate(Date dateInicio, Date dateFin) throws SQLException;

    public ArrayList<Articulo> getAllArticulos() throws SQLException;

    public ArrayList<Articulo> getAllAvailableArticulos() throws SQLException;

    public Boolean createArticulo(Articulo articulo) throws SQLException;

    public Boolean updateArticulo(Articulo articulo) throws SQLException;

    public Boolean activeArticulo(Integer idArticulo, String nombre) throws SQLException;

    public Boolean deleteArticulo(Integer idArticulo) throws SQLException;
}
