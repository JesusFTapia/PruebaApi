package com.example.RequestResponseManager.Model;

import java.util.Date;

public class NuevoPaciente {
    private String idPaciente;
    private String nombre;
    private String apellido;
    private Date fechaCreacion;

    public NuevoPaciente() {
    }

    public NuevoPaciente(String idPaciente, String nombre, String apellido, Date fechaCreacion) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaCreacion = fechaCreacion;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
