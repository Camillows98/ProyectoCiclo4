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

import com.citamedica.citasMedicas.models.CitaModels;
import com.citamedica.citasMedicas.services.CitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {

    public CitaController() {
    }

    @Autowired
    CitaService citaService;

    @GetMapping
    public ArrayList<CitaModels> obtenercitas(){
        return  citaService.obtenercitas();
    }

    @PostMapping
    public CitaModels guardarcita(@RequestBody CitaModels cita) {
        return this.citaService.guardarcita(cita);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarcitaid(@PathVariable("id") Long id) {
        boolean ok = this.citaService.eliminarcita(id);
        if (ok) {
            return "Se elimino con exito";
        } else {
            return "No se elimino por fallas o no se encontro el registro";
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<CitaModels> obtenerporId(@PathVariable("id") Long id) {
        return this.citaService.obtenerporId(id);

    }

    @GetMapping("/query")
    public ArrayList<CitaModels> obtenerporCedulaMedico(@RequestParam("cedula_medico") long cedula) {
        return this.citaService.obtenerporCedulaMedico(cedula);

    }

    @GetMapping("/querycedu")
    public ArrayList<CitaModels> obtenerporCedulaUsuario(@RequestParam("cedula_usuario") long cedula) {
        return this.citaService.obtenerporCedulaUsuario(cedula);

    }
    
}
