package com.citamedica.citasMedicas.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.citamedica.citasMedicas.models.AdminModels;

public interface AdminRepository extends CrudRepository<AdminModels, Long>{
    public abstract ArrayList<AdminModels> findByTelefono(String telefono);
    public abstract ArrayList<AdminModels> findByCedula(Long cedula);
}
