package edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces;


import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Alquiler;

import java.util.ArrayList;

public interface IAlquiler {

    public ArrayList<Alquiler> getAllAlquiler();

    public Alquiler searchAlquilerById(Integer idAlquiler);

    public ArrayList<Alquiler> searchByQuery(String query);

    public String createAlquiler(Alquiler alquiler);

    public String updateAlquiler(Alquiler alquiler);

    public String deleteAlquiler(Integer idAlquiler);
}
