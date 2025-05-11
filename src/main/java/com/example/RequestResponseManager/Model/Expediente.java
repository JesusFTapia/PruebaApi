package com.example.RequestResponseManager.Model;

import java.util.Date;
import java.util.List;

public class Expediente {

    private Date fechaCreacion;
    private List<String> diagnosticos;
    private List<String> vacunas;
    private List<byte[]> radiogradias;
    private List<String> alergias;
    private String notasAdicionales;

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