package com.citamedica.citasMedicas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citamedica.citasMedicas.models.AdminModels;
import com.citamedica.citasMedicas.repositories.AdminRepository;

@Service
public class AdminService {

    public AdminService() {
    }

    @Autowired
    AdminRepository adminRepository;

    public ArrayList<AdminModels> obteneradmins(){
        return (ArrayList<AdminModels>) adminRepository.findAll();
    }

    public AdminModels guardaradmin(AdminModels admin) {
        return adminRepository.save(admin);
    }

    public boolean eliminaradmin(long id) {
        try {
            this.adminRepository.deleteById(id);
            return true;
        } catch (Exception er) {
            return false;
        }

    }
    public Optional<AdminModels> obtenerporId(Long id) {
        return this.adminRepository.findById(id);

    }

    public ArrayList<AdminModels> obtenerporTelefono(String telefono) {
        return this.adminRepository.findByTelefono(telefono);

    }

    public ArrayList<AdminModels> obtenerporCedula(long cedula) {
        return this.adminRepository.findByCedula(cedula);

    }
    
}
