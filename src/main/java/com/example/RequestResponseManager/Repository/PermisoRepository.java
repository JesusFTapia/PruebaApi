package com.example.RequestResponseManager.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.RequestResponseManager.Model.Permiso;

public interface PermisoRepository extends MongoRepository<Permiso, String> {
    Permiso findByDoctorIdAndPacienteId(String doctorId, String pacienteId);
}
