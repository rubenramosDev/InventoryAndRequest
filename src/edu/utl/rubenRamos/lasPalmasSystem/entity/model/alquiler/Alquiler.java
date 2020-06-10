package edu.utl.rubenRamos.lasPalmasSystem.entity.model.alquiler;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Usuario;

import java.util.Date;

public class Alquiler {

    private Integer idPedido;
    private Date fechaInicio;
    private Date fechaFin;
    private String direccionEntrega;
    private String nombreEntrega;
    private String nombreRecolecta;
    private String nombreRecibe;
    private Double flete;
    private Double descuento;
    private Double total;
    private String notas;
    private Usuario usuario;
    private Cliente cliente;
    private EstatusAlquiler estatusAlquiler;

    public Alquiler() {
    }

    public Alquiler(Integer idPedido, Date fechaInicio, Date fechaFin, String direccionEntrega, String nombreEntrega, String nombreRecolecta, String nombreRecibe, Double flete, Double descuento, Double total, String notas, Integer idUsuario, Integer idCliente, Integer idEstatusPedido) {
        this.idPedido = idPedido;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.direccionEntrega = direccionEntrega;
        this.nombreEntrega = nombreEntrega;
        this.nombreRecolecta = nombreRecolecta;
        this.nombreRecibe = nombreRecibe;
        this.flete = flete;
        this.descuento = descuento;
        this.total = total;
        this.notas = notas;
        this.usuario = new Usuario(idUsuario);
        this.cliente = new Cliente(idCliente);
        this.estatusAlquiler = new EstatusAlquiler(idEstatusPedido);
    }

    public Alquiler(Integer idPedido) {
        this.idPedido = idPedido;
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

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstatusAlquiler getEstatusAlquiler() {
        return estatusAlquiler;
    }

    public void setEstatusAlquiler(EstatusAlquiler estatusAlquiler) {
        this.estatusAlquiler = estatusAlquiler;
    }
}
