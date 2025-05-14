package com.example.RequestResponseManager.Model;

public class SolicitudExpediente {
    private String idDoctor;
    private String idPaciente;

    public SolicitudExpediente() {
    }

    public SolicitudExpediente(String idDoctor, String idPaciente) {
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

}
