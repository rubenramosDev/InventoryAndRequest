package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.pedido.Pedido;

public class Faltante {

    private Integer idFaltante;
    private Integer cantidad;
    private Articulo idArticulo;
    private Pedido idPedido;

    public Faltante(Integer idFaltante, Integer cantidad, Integer idArticulo, Integer idPedido) {
        this.idFaltante = idFaltante;
        this.cantidad = cantidad;
        this.idArticulo = new Articulo(idArticulo);
        this.idPedido = new Pedido(idPedido);
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

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }
}
