package com.citamedica.citasMedicas.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citamedica.citasMedicas.models.AdminModels;
import com.citamedica.citasMedicas.services.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {

    public AdminController() {
    }

    @Autowired
    AdminService adminService;

    @GetMapping
    public ArrayList<AdminModels> obteneradmins(){
        return  adminService.obteneradmins();
    }

    @PostMapping
    public AdminModels guardaradmin(@RequestBody AdminModels admin) {
        return this.adminService.guardaradmin(admin);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminaradminid(@PathVariable("id") Long id) {
        boolean ok = this.adminService.eliminaradmin(id);
        if (ok) {
            return "Se elimino con exito";
        } else {
            return "No se elimino por fallas o no se encontro el registro";
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<AdminModels> obtenerporId(@PathVariable("id") Long id) {
        return this.adminService.obtenerporId(id);

    }

    @GetMapping("/query")
    public ArrayList<AdminModels> obtenerporTelefono(@RequestParam("telefono") String telefono) {
        return this.adminService.obtenerporTelefono(telefono);

    }

    @GetMapping("/querycedu")
    public ArrayList<AdminModels> obtenerporCedula(@RequestParam("cedula") long cedula) {
        return this.adminService.obtenerporCedula(cedula);

    }
    
}
