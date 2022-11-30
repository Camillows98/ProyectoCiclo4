package com.citamedica.citasMedicas.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.citamedica.citasMedicas.models.MedicalModels;

public interface MedicalRepository extends CrudRepository<MedicalModels, Long>{
    public abstract ArrayList<MedicalModels> findByTelefono(String telefono);
    public abstract ArrayList<MedicalModels> findByCedula(Long cedula);
}
