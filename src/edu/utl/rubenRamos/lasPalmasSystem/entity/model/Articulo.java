package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

import java.util.ArrayList;

public class Articulo {

    private Integer idArticulo;
    private String nombre;
    private Double precioUnitario;
    private Double precioFaltante;
    private Integer cantidad;
    private CategoriaArticulo categoriaArticulo;
    private String categoriArticuloNameTable;

    public Articulo() {
    }

    public Articulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo(Integer idArticulo, String nombre, Double precioUnitario, Double precioFaltante, Integer cantidad, Integer idCategoria, String categoriaArticulo) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioFaltante = precioFaltante;
        this.cantidad = cantidad;
        this.categoriaArticulo = new CategoriaArticulo(idCategoria, categoriaArticulo);
    }

    public Articulo(String nombre, Double precioUnitario, Double precioFaltante, Integer cantidad, String categoriaArticulo) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioFaltante = precioFaltante;
        this.cantidad = cantidad;
        this.categoriaArticulo = new CategoriaArticulo(categoriaArticulo);
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioFaltante() {
        return precioFaltante;
    }

    public void setPrecioFaltante(Double precioFaltante) {
        this.precioFaltante = precioFaltante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public CategoriaArticulo getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public String getCategoriArticuloNameTable() {
        return categoriaArticulo.getNombre();
    }

    public void setCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }
}
