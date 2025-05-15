package com.example.RequestResponseManager.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.RequestResponseManager.Model.Profesional;

public interface ProfesionalRepository extends MongoRepository<Profesional, String> {
    Profesional findByCedula(String cedula);
}