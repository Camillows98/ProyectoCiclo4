package com.citamedica.citasMedicas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citamedica.citasMedicas.models.CitaModels;
import com.citamedica.citasMedicas.repositories.CitaRepository;

@Service
public class CitaService {

    public CitaService() {
    }

    @Autowired
    CitaRepository citaRepository;

    public ArrayList<CitaModels> obtenercitas(){
        return (ArrayList<CitaModels>) citaRepository.findAll();
    }

    public CitaModels guardarcita(CitaModels cita) {
        return citaRepository.save(cita);
    }

    public boolean eliminarcita(long id) {
        try {
            this.citaRepository.deleteById(id);
            return true;
        } catch (Exception er) {
            return false;
        }

    }

    public Optional<CitaModels> obtenerporId(Long id) {
        return this.citaRepository.findById(id);

    }

    public ArrayList<CitaModels> obtenerporCedulaMedico(Long cedula) {
        return this.citaRepository.findByCedulaMedico(cedula);

    }

    public ArrayList<CitaModels> obtenerporCedulaUsuario(long cedula) {
        return this.citaRepository.findByCedulaUsuario(cedula);

    }
    
}
