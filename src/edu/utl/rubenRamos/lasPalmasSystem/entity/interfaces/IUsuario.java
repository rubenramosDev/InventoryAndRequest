package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUsuario {

    public ArrayList<Usuario> getAllUsuario() throws SQLException;

    public Boolean createUsuario(Usuario usuario) throws SQLException;

    public Boolean updateUsuario(Usuario usuario) throws SQLException;

    public Boolean activeUsuario(Integer idUsuario, String username) throws SQLException;

    public Boolean deleteUsuario(Integer idUsuario) throws SQLException;
}
