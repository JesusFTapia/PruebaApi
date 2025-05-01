package com.example.RequestResponseManager.Expediente;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "expedientes")
public class Expediente {
    @Id
    private String id;
    private String pacienteId;
    // private Date fechaCreacion;
    // private List<Diagnostico> diagnosticos;
    // private List<Vacuna> vacunas;
    private List<String> alergias;
    private String notasAdicionales;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    /*
     * public Date getFechaCreacion() {
     * return fechaCreacion;
     * }
     * 
     * public void setFechaCreacion(Date fechaCreacion) {
     * this.fechaCreacion = fechaCreacion;
     * }
     * 
     * public List<Diagnostico> getDiagnosticos() {
     * return diagnosticos;
     * }
     * 
     * public void setDiagnosticos(List<Diagnostico> diagnosticos) {
     * this.diagnosticos = diagnosticos;
     * }
     * 
     * public List<Vacuna> getVacunas() {
     * return vacunas;
     * }
     * 
     * public void setVacunas(List<Vacuna> vacunas) {
     * this.vacunas = vacunas;
     * }
     */

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public String getNotasAdicionales() {
        return notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }

}