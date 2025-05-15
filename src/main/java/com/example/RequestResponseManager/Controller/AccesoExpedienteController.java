package com.example.RequestResponseManager.Controller;

import com.example.RequestResponseManager.Model.Expediente;
import com.example.RequestResponseManager.Model.NuevoPaciente;
import com.example.RequestResponseManager.Model.Paciente;
import com.example.RequestResponseManager.Model.Permiso;
import com.example.RequestResponseManager.Model.Profesional;
import com.example.RequestResponseManager.Repository.PacienteRepository;
import com.example.RequestResponseManager.Repository.PermisoRepository;
import com.example.RequestResponseManager.Repository.ProfesionalRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccesoExpedienteController {

    private final PacienteRepository pacienteRepository;
    private final PermisoRepository permisoRepository;
    private final ProfesionalRepository profesionalRepository;

    public AccesoExpedienteController(PacienteRepository pacienteRepository, PermisoRepository permisoRepository,
            ProfesionalRepository profesionalRepository) {
        this.pacienteRepository = pacienteRepository;
        this.permisoRepository = permisoRepository;
        this.profesionalRepository = profesionalRepository;
    }

    @PostMapping("/nuevopaciente")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody NuevoPaciente nuevoPaciente) {
        Paciente paciente = new Paciente();
        paciente.setId(nuevoPaciente.getIdPaciente());
        paciente.setNombre(nuevoPaciente.getNombre() + " " + nuevoPaciente.getApellido());
        Expediente expediente = new Expediente();
        expediente.setFechaCreacion(nuevoPaciente.getFechaCreacion());
        paciente.setExpediente(expediente);

        Paciente guardado = pacienteRepository.save(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PostMapping("/generarAcceso/")
    public Permiso create(@RequestBody Permiso permiso) {

        Date fechaGeneracion = permiso.getFechaDeGeneracion();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaGeneracion);

        calendar.add(Calendar.HOUR, 7);
        permiso.setFechaDeGeneracion(calendar.getTime());

        calendar.add(Calendar.HOUR, 24);
        permiso.setFechaVencimiento(calendar.getTime());

        return permisoRepository.save(permiso);
    }

    /*
     * @PatchMapping
     * public boolean parchear(@RequestBody Paciente paciente){
     * paciente2= repository.findById(null);
     * tipo=json.
     * if(){
     * pacient
     * }
     * paciente2.expediente
     * }
     */

    @GetMapping("/expediente")
    public ResponseEntity<Expediente> getExpediente(@RequestParam String idDoctor, @RequestParam String idPaciente) {
        Permiso permiso = permisoRepository.findByIdDoctorAndIdPaciente(idDoctor, idPaciente);
        if (permiso != null) {
            return ResponseEntity.ok(pacienteRepository.findById(idPaciente).get().getExpediente());
        } else {
            return null;
        }
    }

    @GetMapping("/expedientes/{idPaciente}")
    public ResponseEntity<Expediente> getPaciente(@PathVariable String idPaciente) {
        return ResponseEntity.ok(pacienteRepository.findById(idPaciente).get().getExpediente());

    }

    @GetMapping("/profesionales")
    public ResponseEntity<List<Profesional>> getAllProfesionales() {
        List<Profesional> profesionales = profesionalRepository.findAll();
        return ResponseEntity.ok(profesionales);
    }

}