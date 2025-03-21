package com.ProyectoFinal.PathfinderBuilder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinal.PathfinderBuilder.service.PersonajeDTO;
import com.ProyectoFinal.PathfinderBuilder.service.PersonajeService;


import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping()
    public ResponseEntity<?> getAllPersonajes() {
        return  ResponseEntity.ok(personajeService.getAllPersonajes());
    }

    // creo un personaje y lo guardo en la base de datos
    @PostMapping()
    public ResponseEntity<?> savePersonaje(@RequestBody PersonajeDTO personajeDTO) {
        return  ResponseEntity.ok(personajeService.savePersonaje(personajeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonaje(@PathParam("id") Long id, @RequestBody PersonajeDTO personajeDTO) {
        return  ResponseEntity.ok(personajeService.actualizarPersonaje(id, personajeDTO));
    }

}
