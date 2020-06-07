package edu.utl.rubenRamos.lasPalmasSystem.entity.model.reservacion;

public class EstatusReservacion {

    private Integer idEstatusReservacion;
    private String estatusReservacion;

    public EstatusReservacion() {
    }

    public EstatusReservacion(Integer idEstatusReservacion) {
        this.idEstatusReservacion = idEstatusReservacion;
    }

    public EstatusReservacion(Integer idEstatusReservacion, String estatusReservacion) {
        this.idEstatusReservacion = idEstatusReservacion;
        this.estatusReservacion = estatusReservacion;
    }

    public Integer getIdEstatusReservacion() {
        return idEstatusReservacion;
    }

    public void setIdEstatusReservacion(Integer idEstatusReservacion) {
        this.idEstatusReservacion = idEstatusReservacion;
    }

    public String getEstatusReservacion() {
        return estatusReservacion;
    }

    public void setEstatusReservacion(String estatusReservacion) {
        this.estatusReservacion = estatusReservacion;
    }
}
