package com.example.RequestResponseManager.Expediente;

import com.example.RequestResponseManager.Expediente.Expediente;
import com.example.RequestResponseManager.Expediente.ExpedienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expedientes")
public class ExpedienteController {

    private final ExpedienteRepository repository;

    public ExpedienteController(ExpedienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Expediente> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Expediente create(@RequestBody Expediente expediente) {
        return repository.save(expediente);
    }

    @GetMapping("/{id}")
    public Expediente getById(@PathVariable String id) {
        return repository.findExpedienteById(id);
    }
}