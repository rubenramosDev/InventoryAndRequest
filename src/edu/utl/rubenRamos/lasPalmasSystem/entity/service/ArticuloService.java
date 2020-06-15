package edu.utl.rubenRamos.lasPalmasSystem.entity.service;

import edu.utl.rubenRamos.lasPalmasSystem.entity.dao.ArticuloDao;
import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;

import java.sql.SQLException;


public class ArticuloService {

    private IArticulo articuloDao = new ArticuloDao();

    public Boolean createArticulo(String nombre, Double precioUnitario, Double precioFaltante, Integer cantidad, Integer idCategoria, String pathImage) {
        try {
            return articuloDao.createArticulo(new Articulo(nombre, precioUnitario, precioFaltante, cantidad, pathImage, idCategoria));
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }

    public Boolean updateArticulo(Integer idArticulo, String nombre, Double precioUnitario, Double
            precioFaltante, Integer cantidad, Integer idCategoria, String pathImage) {
        try {
            return articuloDao.updateArticulo(new Articulo(idArticulo, nombre, precioUnitario, precioFaltante, cantidad, pathImage, idCategoria));
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }

    public Boolean deleteArticulo(Integer idArticulo) {
        try {
            return articuloDao.deleteArticulo(idArticulo);
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }
}
