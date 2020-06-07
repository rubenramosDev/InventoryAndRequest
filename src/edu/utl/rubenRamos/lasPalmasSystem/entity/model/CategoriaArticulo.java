package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public class CategoriaArticulo {
    private Integer idCategoria;
    private String nombre;
    private String forma;
    private String categoriArticuloNameTable;

    public CategoriaArticulo() {
    }

    public CategoriaArticulo(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaArticulo(Integer idCategoria, String nombre, String forma) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.forma = forma;
    }

    public CategoriaArticulo(String nombreCategoriaArticulo, String forma) {
        this.nombre = nombreCategoriaArticulo;
        this.forma = forma;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }


}
