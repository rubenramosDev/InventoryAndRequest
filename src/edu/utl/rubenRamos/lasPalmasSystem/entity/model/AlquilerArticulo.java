package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public class AlquilerArticulo {

    private Integer idPedidoArticulo;
    private Integer cantidad;
    private Articulo articulo;
    private Alquiler alquiler;

    public AlquilerArticulo() {
    }

    public AlquilerArticulo(Integer idPedidoArticulo, Integer cantidad, Integer idArticulo, Integer idPedido) {
        this.idPedidoArticulo = idPedidoArticulo;
        this.cantidad = cantidad;
        this.articulo = new Articulo(idArticulo);
        this.alquiler = new Alquiler(idPedido);
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

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Double monto() {
        return articulo.getPrecioUnitario() * cantidad;
    }
}
