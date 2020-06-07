package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public class Cliente {

    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String direccionParticular;
    private String ciudad;
    private String telefono;
    private String nombreOrganizacion;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombre, String apellido, String direccionParticular, String ciudad, String telefono, String nombreOrganizacion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccionParticular = direccionParticular;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public Cliente(String nombre, String apellido, String direccionParticular, String ciudad, String telefono, String nombreOrganizacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccionParticular = direccionParticular;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getDireccionParticular() {
        return direccionParticular;
    }

    public void setDireccionParticular(String direccionParticular) {
        this.direccionParticular = direccionParticular;
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

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }
}
