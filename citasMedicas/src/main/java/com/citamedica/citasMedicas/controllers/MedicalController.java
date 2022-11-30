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

import com.citamedica.citasMedicas.models.MedicalModels;
import com.citamedica.citasMedicas.services.MedicalService;

@RestController
@RequestMapping("/medicos")
public class MedicalController {

    public MedicalController() {
    }

    @Autowired
    MedicalService medicalService;

    @GetMapping
    public ArrayList<MedicalModels> obtenerusuarios(){
        return  medicalService.obtenermedicos();
    }

    @PostMapping
    public MedicalModels guardarmedico(@RequestBody MedicalModels medico) {
        return this.medicalService.guardarmedico(medico);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarmedicoid(@PathVariable("id") Long id) {
        boolean ok = this.medicalService.eliminarmedico(id);
        if (ok) {
            return "Se elimino con exito";
        } else {
            return "No se elimino por fallas o no se encontro el registro";
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<MedicalModels> obtenerporId(@PathVariable("id") Long id) {
        return this.medicalService.obtenerporId(id);

    }

    @GetMapping("/query")
    public ArrayList<MedicalModels> obtenerporTelefono(@RequestParam("telefono") String telefono) {
        return this.medicalService.obtenerporTelefono(telefono);

    }

    @GetMapping("/querycedu")
    public ArrayList<MedicalModels> obtenerporCedula(@RequestParam("cedula") long cedula) {
        return this.medicalService.obtenerporCedula(cedula);

    }
    
}
