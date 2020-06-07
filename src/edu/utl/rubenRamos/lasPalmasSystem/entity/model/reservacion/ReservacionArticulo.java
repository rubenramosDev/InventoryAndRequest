package edu.utl.rubenRamos.lasPalmasSystem.entity.model.reservacion;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;

public class ReservacionArticulo {

    private Integer idReservacionArticulo;
    private Integer cantidad;
    private Integer precioUnitario;
    private Articulo articulo;
    private Reservacion reservacion;

    public ReservacionArticulo() {
    }

    public ReservacionArticulo(Integer idReservacionArticulo, Integer cantidad, Integer precioUnitario, Integer  idArticulo, Integer idReservacion) {
        this.idReservacionArticulo = idReservacionArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.articulo = new Articulo(idArticulo);
        this.reservacion = new Reservacion(idReservacion);
    }

    public Integer getIdReservacionArticulo() {
        return idReservacionArticulo;
    }

    public void setIdReservacionArticulo(Integer idReservacionArticulo) {
        this.idReservacionArticulo = idReservacionArticulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }
}
