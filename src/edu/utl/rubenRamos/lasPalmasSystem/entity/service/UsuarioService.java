package edu.utl.rubenRamos.lasPalmasSystem.entity.service;

import edu.utl.rubenRamos.lasPalmasSystem.entity.dao.UsuarioDao;
import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IUsuario;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Usuario;
import edu.utl.rubenRamos.lasPalmasSystem.utils.ContextualWindow;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioService {

    private IUsuario usuarioDao = new UsuarioDao();

    public ArrayList<Usuario> getAllUsuario() {
        try {
            return usuarioDao.getAllUsuario();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public Boolean createUsuario(String nombre, String apellido, String username, String password, String privileges) {
        try {
            return usuarioDao.createUsuario(new Usuario(nombre, apellido, username, password, privileges));
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }

    public Boolean updateUsuario(Integer idUsuario, String nombre, String apellido, String username, String password, String privileges) {
        try {
            return usuarioDao.updateUsuario(new Usuario(idUsuario, nombre, apellido, username, password, privileges));
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }

    public Boolean activeUsuario(Integer idUsuario, String username) {
        return null;
    }

    public Boolean deleteUsuario(Integer idUsuario) {
        try {
            return usuarioDao.deleteUsuario(idUsuario);
        } catch (SQLException exception) {
            ContextualWindow.contextualWindowException(exception);
            System.out.println("SQLState: ".concat(exception.getSQLState()).concat(" Menssage: ").concat(exception.getMessage()));
            return false;
        }
    }
}
