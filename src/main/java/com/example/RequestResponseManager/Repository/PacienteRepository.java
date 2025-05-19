package com.example.RequestResponseManager.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.RequestResponseManager.Model.Paciente;

public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Paciente findByIdPaciente(String idPaciente);
}