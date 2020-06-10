package edu.utl.rubenRamos.lasPalmasSystem.entity.dao;

import edu.utl.rubenRamos.lasPalmasSystem.entity.interfaces.IAlquiler;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.alquiler.Alquiler;

import java.util.ArrayList;

public class AlquilerDao implements IAlquiler {

    @Override
    public ArrayList<Alquiler> getAllAlquiler() {
        return null;
    }

    @Override
    public Alquiler searchAlquilerById(Integer idAlquiler) {
        return null;
    }

    @Override
    public ArrayList<Alquiler> searchByQuery(String query) {
        return null;
    }

    @Override
    public String createAlquiler(Alquiler alquiler) {
        return null;
    }

    @Override
    public String updateAlquiler(Alquiler alquiler) {
        return null;
    }

    @Override
    public String deleteAlquiler(Integer idAlquiler) {
        return null;
    }
}
