package com.example.RequestResponseManager.Expediente;

import com.example.RequestResponseManager.Expediente.Expediente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpedienteRepository extends MongoRepository<Expediente, String> {
    Expediente findExpedienteById(String id);
}