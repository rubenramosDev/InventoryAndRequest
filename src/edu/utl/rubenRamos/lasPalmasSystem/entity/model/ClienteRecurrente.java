package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public class ClienteRecurrente {

    private Integer idClienteRecurrente;
    private String nombre;
    private String apellido;
    private String direccionParticular;
    private String ciudad;
    private String telefono;
    private String nombreOrganizacion;

    public Integer getIdClienteRecurrente() {
        return idClienteRecurrente;
    }

    public void setIdClienteRecurrente(Integer idClienteRecurrente) {
        this.idClienteRecurrente = idClienteRecurrente;
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
