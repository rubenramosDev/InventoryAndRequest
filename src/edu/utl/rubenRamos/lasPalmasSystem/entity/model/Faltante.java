package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public class Faltante {

    private Integer idFaltante;
    private Integer cantidad;
    private Articulo idArticulo;
    private Alquiler idAlquiler;

    public Faltante(Integer idFaltante, Integer cantidad, Integer idArticulo, Integer idPedido) {
        this.idFaltante = idFaltante;
        this.cantidad = cantidad;
        this.idArticulo = new Articulo(idArticulo);
        this.idAlquiler = new Alquiler(idPedido);
    }

    public Integer getIdFaltante() {
        return idFaltante;
    }

    public void setIdFaltante(Integer idFaltante) {
        this.idFaltante = idFaltante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Alquiler getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Alquiler idAlquiler) {
        this.idAlquiler = idAlquiler;
    }
}
