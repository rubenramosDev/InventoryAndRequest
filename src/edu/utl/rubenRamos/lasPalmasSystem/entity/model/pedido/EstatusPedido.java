package edu.utl.rubenRamos.lasPalmasSystem.entity.model.pedido;

public class EstatusPedido {

    private Integer idEstatusPedido;
    private String EstatusPedido;

    public EstatusPedido() {
    }

    public EstatusPedido(Integer idEstatusPedido) {
        this.idEstatusPedido = idEstatusPedido;
    }

    public EstatusPedido(Integer idEstatusPedido, String estatusPedido) {
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
