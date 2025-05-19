package com.example.RequestResponseManager.Controller;

import com.example.RequestResponseManager.Model.Expediente;
import com.example.RequestResponseManager.Model.NuevoPaciente;
import com.example.RequestResponseManager.Model.Paciente;
import com.example.RequestResponseManager.Model.Permiso;
import com.example.RequestResponseManager.Model.Profesional;
import com.example.RequestResponseManager.Model.SolicitudActualizar;
import com.example.RequestResponseManager.Repository.PacienteRepository;
import com.example.RequestResponseManager.Repository.PermisoRepository;
import com.example.RequestResponseManager.Repository.ProfesionalRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Date fechadehoy = new Date();

        Date fechaGeneracionOriginal = permiso.getFechaDeGeneracion();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechadehoy);

        calendar.add(Calendar.HOUR, 7);
        permiso.setFechaDeGeneracion(calendar.getTime());

        calendar.add(Calendar.HOUR, 24);
        permiso.setFechaVencimiento(calendar.getTime());

        Permiso permisoGuardado = permisoRepository.save(permiso);

        /*
         * permisoGuardado.setFechaDeGeneracion(fechaGeneracionOriginal);
         * calendar.setTime(fechaGeneracionOriginal);
         * calendar.add(Calendar.HOUR, 24);
         * permisoGuardado.setFechaVencimiento(calendar.getTime());
         */
        return permisoGuardado;
    }

    @PostMapping("/expedientes/actualizar")
    public boolean parchear(@RequestBody SolicitudActualizar solicitud) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(solicitud.getIdPaciente());

        if (!optionalPaciente.isPresent()) {
            return false;
        }
        Paciente paciente = optionalPaciente.get();
        if (solicitud.getTipo().equalsIgnoreCase("diagnosticos")) {
            paciente.getExpediente().getDiagnosticos().add(solicitud.getContenido());
            pacienteRepository.save(paciente);
            return true;
        } else if (solicitud.getTipo().equalsIgnoreCase("vacunas")) {
            paciente.getExpediente().getVacunas().add(solicitud.getContenido());
            pacienteRepository.save(paciente);
            return true;
        } else if (solicitud.getTipo().equalsIgnoreCase("radiografias")) {
            byte[] imagenBytes = Base64.getDecoder().decode(solicitud.getContenido());
            paciente.getExpediente().getRadiografias().add(imagenBytes);
            pacienteRepository.save(paciente);
            return true;
        } else if (solicitud.getTipo().equalsIgnoreCase("alergias")) {
            paciente.getExpediente().getAlergias().add(solicitud.getContenido());
            pacienteRepository.save(paciente);
            return true;
        } else {
            return false;
        }
    }

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