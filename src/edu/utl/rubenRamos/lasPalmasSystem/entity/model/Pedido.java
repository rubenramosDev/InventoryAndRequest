package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

import java.util.Date;

public class Pedido {

    private Integer idPedido;
    private Date fechaInicio;
    private Date fechaFin;
    private String nombreCliente;
    private String direccionParticular;
    private String direccionEntrega;
    private String ciudad;
    private String telefono;
    private String nombreEntrega;
    private String nombreRecolecta;
    private String nombreRecibe;
    private Double flete;
    private Double descuento;
    private Double pagoActual;
    private Double total;
    private String notas;
    private Usuario usuario;
    private EstatusPedido estatusPedido;

    public Pedido(){}

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, Date fechaInicio, Date fechaFin, String nombreCliente, String direccionParticular, String direccionEntrega, String ciudad, String telefono, String nombreEntrega, String nombreRecolecta, String nombreRecibe, Double flete, Double descuento, Double pagoActual, Double total, String notas, Integer idUsuario, Integer idEstatusPedido) {
        this.idPedido = idPedido;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombreCliente = nombreCliente;
        this.direccionParticular = direccionParticular;
        this.direccionEntrega = direccionEntrega;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.nombreEntrega = nombreEntrega;
        this.nombreRecolecta = nombreRecolecta;
        this.nombreRecibe = nombreRecibe;
        this.flete = flete;
        this.descuento = descuento;
        this.pagoActual = pagoActual;
        this.total = total;
        this.notas = notas;
        this.usuario = new Usuario(idUsuario);
        this.estatusPedido = new EstatusPedido(idEstatusPedido);
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionParticular() {
        return direccionParticular;
    }

    public void setDireccionParticular(String direccionParticular) {
        this.direccionParticular = direccionParticular;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreEntrega() {
        return nombreEntrega;
    }

    public void setNombreEntrega(String nombreEntrega) {
        this.nombreEntrega = nombreEntrega;
    }

    public String getNombreRecolecta() {
        return nombreRecolecta;
    }

    public void setNombreRecolecta(String nombreRecolecta) {
        this.nombreRecolecta = nombreRecolecta;
    }

    public String getNombreRecibe() {
        return nombreRecibe;
    }

    public void setNombreRecibe(String nombreRecibe) {
        this.nombreRecibe = nombreRecibe;
    }

    public Double getFlete() {
        return flete;
    }

    public void setFlete(Double flete) {
        this.flete = flete;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPagoActual() {
        return pagoActual;
    }

    public void setPagoActual(Double pagoActual) {
        this.pagoActual = pagoActual;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstatusPedido getEstatusPedido() {
        return estatusPedido;
    }

    public void setEstatusPedido(EstatusPedido estatusPedido) {
        this.estatusPedido = estatusPedido;
    }
}
