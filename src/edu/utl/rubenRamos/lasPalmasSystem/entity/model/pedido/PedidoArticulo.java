package edu.utl.rubenRamos.lasPalmasSystem.entity.model.pedido;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Articulo;

public class PedidoArticulo {

    private Integer idPedidoArticulo;
    private Integer cantidad;
    private Articulo articulo;
    private Pedido pedido;

    public PedidoArticulo() {
    }

    public PedidoArticulo(Integer idPedidoArticulo, Integer cantidad, Integer idArticulo, Integer idPedido) {
        this.idPedidoArticulo = idPedidoArticulo;
        this.cantidad = cantidad;
        this.articulo = new Articulo(idArticulo);
        this.pedido = new Pedido(idPedido);
    }

    public Integer getIdPedidoArticulo() {
        return idPedidoArticulo;
    }

    public void setIdPedidoArticulo(Integer idPedidoArticulo) {
        this.idPedidoArticulo = idPedidoArticulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
