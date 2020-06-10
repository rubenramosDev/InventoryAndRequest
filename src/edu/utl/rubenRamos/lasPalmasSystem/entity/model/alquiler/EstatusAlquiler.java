package edu.utl.rubenRamos.lasPalmasSystem.entity.model.alquiler;

public class EstatusAlquiler {

    private Integer idEstatusPedido;
    private String EstatusPedido;

    public EstatusAlquiler() {
    }

    public EstatusAlquiler(Integer idEstatusPedido) {
        this.idEstatusPedido = idEstatusPedido;
    }

    public EstatusAlquiler(Integer idEstatusPedido, String estatusPedido) {
        this.idEstatusPedido = idEstatusPedido;
        EstatusPedido = estatusPedido;
    }

    public Integer getIdEstatusPedido() {
        return idEstatusPedido;
    }

    public void setIdEstatusPedido(Integer idEstatusPedido) {
        this.idEstatusPedido = idEstatusPedido;
    }

    public String getEstatusPedido() {
        return EstatusPedido;
    }

    public void setEstatusPedido(String estatusPedido) {
        EstatusPedido = estatusPedido;
    }
}
