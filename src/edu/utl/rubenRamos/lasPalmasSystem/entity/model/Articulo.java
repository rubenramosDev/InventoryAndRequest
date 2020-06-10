package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

import java.util.ArrayList;


public class Articulo {

    private Integer idArticulo;
    private String nombre;
    private Double precioUnitario;
    private Double precioFaltante;
    private Integer cantidad;
    private CategoriaArticulo categoriaArticulo;
    private String pathImage;
    private Boolean estatus;
    private String categoriArticuloNameTable;
    private String categoriaArticuloFormaTable;

    public Articulo() {
    }

    public Articulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo(Integer idArticulo, String nombre, Double precioUnitario, Double precioFaltante, Integer cantidad, String pathImage, Integer idCategoria, String nombreCategoria, String forma) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioFaltante = precioFaltante;
        this.cantidad = cantidad;
        this.pathImage = pathImage;
        this.categoriaArticulo = new CategoriaArticulo(idCategoria, nombreCategoria, forma);
    }

    public Articulo(Integer idArticulo, String nombre, Double precioUnitario, Double precioFaltante, Integer cantidad, String pathImage, Integer idCategoriaArticulo) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioFaltante = precioFaltante;
        this.cantidad = cantidad;
        this.pathImage = pathImage;
        this.categoriaArticulo = new CategoriaArticulo(idCategoriaArticulo);
    }

    public Articulo(String nombre, Double precioUnitario, Double precioFaltante, Integer cantidad, String pathImage, Integer idCategoria) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioFaltante = precioFaltante;
        this.cantidad = cantidad;
        this.pathImage = pathImage;
        this.categoriaArticulo = new CategoriaArticulo(idCategoria);
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

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public String getCategoriArticuloNameTable() {
        return categoriaArticulo.getNombre();
    }

    public void setCategoriArticuloNameTable(String categoriArticuloNameTable) {
        this.categoriArticuloNameTable = categoriArticuloNameTable;
    }

    public String getCategoriaArticuloFormaTable() {
        return categoriaArticuloFormaTable;
    }

    public void setCategoriaArticuloFormaTable(String categoriaArticuloFormaTable) {
        this.categoriaArticuloFormaTable = categoriaArticuloFormaTable;
    }

    public void setCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }

}
