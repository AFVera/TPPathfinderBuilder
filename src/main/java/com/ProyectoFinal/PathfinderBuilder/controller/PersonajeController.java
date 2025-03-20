package com.ProyectoFinal.PathfinderBuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinal.PathfinderBuilder.service.PersonajeService;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;
    
    @GetMapping()
    public ResponseEntity<?> getAllPersonajes() {
        return  ResponseEntity.ok(personajeService.getAllPersonajes());
    }



}
