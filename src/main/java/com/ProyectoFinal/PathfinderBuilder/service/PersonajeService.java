package com.ProyectoFinal.PathfinderBuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoFinal.PathfinderBuilder.model.Personaje;
import com.ProyectoFinal.PathfinderBuilder.repository.PersonajeRepository;
@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public Personaje save(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    public List<PersonajeDTO> getAllPersonajes() {
        return personajeRepository.findAll().stream().map(PersonajeMapper::toDTO).toList();
    }
}
