package com.example.RequestResponseManager.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profesionales")
public class Profesional {

    private String cedula;
    private String nombre;

    public Profesional() {
    }

    public Profesional(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
