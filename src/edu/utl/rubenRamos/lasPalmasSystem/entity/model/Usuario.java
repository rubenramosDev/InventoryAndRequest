package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public class Usuario {

    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String privilegios;
    private Boolean estatus;

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String nombre, String apellido, String usuario, String password, String privilegios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.privilegios = privilegios;
    }

    public Usuario(String nombre, String apellido, String usuario, String password, String privilegios, Boolean estatus) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.privilegios = privilegios;
        this.estatus = estatus;
    }

    public Usuario(Integer idUsuario, String nombre, String apellido, String usuario, String password, String privilegios, Boolean estatus) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.privilegios = privilegios;
        this.estatus = estatus;
    }

    public Usuario(Integer idUsuario, String nombre, String apellido, String usuario, String password, String privilegios) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.privilegios = privilegios;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}
