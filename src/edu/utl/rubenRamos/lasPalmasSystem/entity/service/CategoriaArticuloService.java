package edu.utl.rubenRamos.lasPalmasSystem.entity.service;

import edu.utl.rubenRamos.lasPalmasSystem.entity.dao.CategoriaArticuloDao;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.CategoriaArticulo;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaArticuloService {

    private CategoriaArticuloDao categoriaArticuloDao = new CategoriaArticuloDao();

    public ArrayList<CategoriaArticulo> getAllCategoriaArticulo() {
        try {
            return categoriaArticuloDao.getAllCategoriaArticulo();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public Boolean createCategoriaArticulo(String nombreCategoriaArticulo, String forma) {
        try {
            return categoriaArticuloDao.createCategoriaArticulo(new CategoriaArticulo(nombreCategoriaArticulo, forma));
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }

    public Boolean updateCategoriaArticulo(String nombre, Integer idCategoriaArticulo, String forma) {
        try {
            return categoriaArticuloDao.updateCategoriaArticulo(new CategoriaArticulo(idCategoriaArticulo, nombre, forma));
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }

}
