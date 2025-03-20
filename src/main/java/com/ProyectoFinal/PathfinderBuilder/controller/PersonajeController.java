package com.ProyectoFinal.PathfinderBuilder.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinal.PathfinderBuilder.service.PersonajeDTO;
import com.ProyectoFinal.PathfinderBuilder.service.PersonajeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping()
    public ResponseEntity<?> getAllPersonajes() {
        return  ResponseEntity.ok(personajeService.getAllPersonajes());
    }

    //creo un personaje y lo guardo en la base de datos
    @PostMapping()
    public ResponseEntity<?> savePersonaje2(PersonajeDTO personajeDTO) {
        System.out.println("parate hdp");
        return  ResponseEntity.ok(personajeService.savePersonaje(personajeDTO));
    //    return  (ResponseEntity<?>) ResponseEntity.ok();
    }
}
