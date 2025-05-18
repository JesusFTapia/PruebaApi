package com.example.RequestResponseManager.Model;

public class SolicitudActualizar {

    private String idPaciente;
    private String tipo;
    private String contenido;

    public SolicitudActualizar() {
    }

    public SolicitudActualizar(String idPaciente, String tipo, String contenido) {
        this.idPaciente = idPaciente;
        this.tipo = tipo;
        this.contenido = contenido;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
