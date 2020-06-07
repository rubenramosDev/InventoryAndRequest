package edu.utl.rubenRamos.lasPalmasSystem.entity.model.reservacion;

import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Cliente;
import edu.utl.rubenRamos.lasPalmasSystem.entity.model.Usuario;

import java.util.Date;

public class Reservacion {

    private Integer idReservacion;
    private Date fechaInicio;
    private Date fechaFin;
    private Double pagoActual;
    private Double total;
    private String notas;
    private Usuario usuario;
    private EstatusReservacion estatusReservacion;
    private Cliente cliente;

    public Reservacion() {
    }

    public Reservacion(Integer idReservacion, Date fechaInicio, Date fechaFin, Double pagoActual, Double total, String notas, Integer idUsuario, Integer idEstatusReservacion, Integer idCliente) {
        this.idReservacion = idReservacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pagoActual = pagoActual;
        this.total = total;
        this.notas = notas;
        this.usuario = new Usuario(idUsuario);
        this.estatusReservacion = new EstatusReservacion(idEstatusReservacion);
        this.cliente = new Cliente(idCliente);
    }

    public Reservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Integer getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
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

    public EstatusReservacion getEstatusReservacion() {
        return estatusReservacion;
    }

    public void setEstatusReservacion(EstatusReservacion estatusReservacion) {
        this.estatusReservacion = estatusReservacion;
    }
}
