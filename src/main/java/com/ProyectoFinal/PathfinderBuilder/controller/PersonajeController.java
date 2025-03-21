package com.ProyectoFinal.PathfinderBuilder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinal.PathfinderBuilder.service.PersonajeRequest;
import com.ProyectoFinal.PathfinderBuilder.service.PersonajeService;


import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;
    // obtengo todos los personajes
    @GetMapping()
    public ResponseEntity<?> getAllPersonajes() {
        return  ResponseEntity.ok(personajeService.getAllPersonajes());
    }
    // creo un personaje y lo guardo en la base de datos
    @PostMapping()
    public ResponseEntity<?> savePersonaje(@RequestBody PersonajeRequest personaje) {
        return  ResponseEntity.ok(personajeService.savePersonaje(personaje));
    }
    // actualizo un personaje segun su id
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonaje(@PathParam("id") Long id, @RequestBody PersonajeRequest personaje) {
        return  ResponseEntity.ok(personajeService.actualizarPersonaje(id, personaje));
    }
    // borro un personaje segun su id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonaje(@PathParam("id") Long id) {
        return  ResponseEntity.ok(personajeService.borrarPersonaje(id));
    }
    //hacer pelear a 2 personajes a muerte
    @PutMapping("/pelear/{id1}/{id2}")
    public ResponseEntity<?> pelearPersonajes(@PathParam("id1") Long id1, @PathParam("id2") Long id2) {
        return ResponseEntity.ok(personajeService.pelearPersonajes(id1, id2));
    }


}
