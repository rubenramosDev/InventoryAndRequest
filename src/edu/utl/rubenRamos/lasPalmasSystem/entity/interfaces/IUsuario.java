package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Usuario;

import java.util.ArrayList;

public interface IUsuario {

    public ArrayList<Usuario> getAllUsuario();

    public String createUsuario(Usuario articulo);

    public String updateUsuario(Usuario articulo);

    public String deleteUsuario(Integer idArticulo);
}
