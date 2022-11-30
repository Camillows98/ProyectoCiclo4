package com.citamedica.citasMedicas.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.citamedica.citasMedicas.models.CitaModels;

public interface CitaRepository extends CrudRepository<CitaModels, Long>{
    public abstract ArrayList<CitaModels> findByCedulaMedico(Long cedula);
    public abstract ArrayList<CitaModels> findByCedulaUsuario(Long cedula);
}
