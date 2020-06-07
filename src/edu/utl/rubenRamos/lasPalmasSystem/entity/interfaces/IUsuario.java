package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Usuario;

import java.util.ArrayList;

public interface IUsuario {

    public ArrayList<Usuario> getAllUsuario();

    public Boolean createUsuario(String nombre, String apellido, String username, String password, String privileges);

    public Boolean updateUsuario(Integer idUsuario, String nombre, String apellido, String username, String password, String privileges);

    public Boolean activeUsuario(Integer idUsuario, String username);

    public Boolean deleteUsuario(Integer idUsuario);
}
