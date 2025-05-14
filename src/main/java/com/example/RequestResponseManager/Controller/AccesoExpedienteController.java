package com.example.RequestResponseManager.Controller;

import com.example.RequestResponseManager.Model.Expediente;
import com.example.RequestResponseManager.Model.Paciente;
import com.example.RequestResponseManager.Model.Permiso;
import com.example.RequestResponseManager.Repository.PacienteRepository;
import com.example.RequestResponseManager.Repository.PermisoRepository;

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

    public AccesoExpedienteController(PacienteRepository pacienteRepository, PermisoRepository permisoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.permisoRepository = permisoRepository;
    }

    @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente) {
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

    @GetMapping("/expedientes/{pacienteId}")
    public ResponseEntity<Expediente> getExpediente(@RequestParam String idPaciente) {
        return ResponseEntity.ok(pacienteRepository.findById(idPaciente).get().getExpediente());

    }

}