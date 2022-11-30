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

import com.citamedica.citasMedicas.models.UserModels;
import com.citamedica.citasMedicas.services.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    public UserController() {
    }

    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModels> obtenerusuarios(){
        return  userService.obtenerusuarios();
    }

    @PostMapping
    public UserModels guardardatos(@RequestBody UserModels usuario) {
        return this.userService.guardardatos(usuario);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminardatoid(@PathVariable("id") Long id) {
        boolean ok = this.userService.eliminarusuario(id);
        if (ok) {
            return "Se elimino con exito";
        } else {
            return "No se elimino por fallas o no se encontro el registro";
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModels> obtenerporId(@PathVariable("id") Long id) {
        return this.userService.obtenerporId(id);

    }

    @GetMapping("/query")
    public ArrayList<UserModels> obtenerporTelefono(@RequestParam("telefono") String telefono) {
        return this.userService.obtenerporTelefono(telefono);

    }

    @GetMapping("/querycedu")
    public ArrayList<UserModels> obtenerporCedula(@RequestParam("cedula") long cedula) {
        return this.userService.obtenerporCedula(cedula);

    }
    
}
