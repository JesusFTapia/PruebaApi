package com.example.RequestResponseManager.Model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "permisos")
public class Permiso {

    private String idPaciente;
    private String idDoctor;
    private Date fechaDeGeneracion;
    private Date fechaVencimiento;

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Date getFechaDeGeneracion() {
        return fechaDeGeneracion;
    }

    public void setFechaDeGeneracion(Date fechaDeGeneracion) {
        this.fechaDeGeneracion = fechaDeGeneracion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
