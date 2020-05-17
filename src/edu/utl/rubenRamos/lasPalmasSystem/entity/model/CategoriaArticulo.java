package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public class CategoriaArticulo {
    private Integer idCategoria;
    private String nombre;

    public CategoriaArticulo() {
    }

    /*Used by Articulo*/
    public CategoriaArticulo(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaArticulo(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
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
}
