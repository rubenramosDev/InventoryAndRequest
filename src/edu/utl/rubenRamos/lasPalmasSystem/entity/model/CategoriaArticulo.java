package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public class CategoriaArticulo {
    private Integer idCategoria;
    private String nombre;
    private String categoriArticuloNameTable;

    public CategoriaArticulo() {
    }

    public CategoriaArticulo(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaArticulo(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public CategoriaArticulo(String nombreCategoriaArticulo) {
        this.nombre = nombreCategoriaArticulo;
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
