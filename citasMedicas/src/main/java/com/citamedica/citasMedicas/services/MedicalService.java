package com.citamedica.citasMedicas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citamedica.citasMedicas.models.MedicalModels;
import com.citamedica.citasMedicas.repositories.MedicalRepository;

@Service
public class MedicalService {

    public MedicalService() {
    }

    @Autowired
    MedicalRepository medicalRepository;

    public ArrayList<MedicalModels> obtenermedicos(){
        return (ArrayList<MedicalModels>) medicalRepository.findAll();
    }

    public MedicalModels guardarmedico(MedicalModels medico) {
        return medicalRepository.save(medico);
    }

    public boolean eliminarmedico(long id) {
        try {
            this.medicalRepository.deleteById(id);
            return true;
        } catch (Exception er) {
            return false;
        }

    }

    public Optional<MedicalModels> obtenerporId(Long id) {
        return this.medicalRepository.findById(id);

    }

    public ArrayList<MedicalModels> obtenerporTelefono(String telefono) {
        return this.medicalRepository.findByTelefono(telefono);

    }

    public ArrayList<MedicalModels> obtenerporCedula(long cedula) {
        return this.medicalRepository.findByCedula(cedula);

    }
    
}
