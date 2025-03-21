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

    public PersonajeDTO savePersonaje(PersonajeDTO personajeDTO) {
        return PersonajeMapper.toDTO(personajeRepository.save(PersonajeMapper.toEntity(personajeDTO)));
    }

    public PersonajeDTO actualizarPersonaje(Long id, PersonajeDTO personajeDTO) {
        Personaje personaje = personajeRepository.findById(id).orElse(null);
        personaje.setDueñoDelPersonaje(personajeDTO.getDueñoDelPersonaje());
        personaje.setNombre(personajeDTO.getNombre());
        personaje.setProfesion(personajeDTO.getProfesion());
        personaje.setHpTotal(personajeDTO.getHpTotal());
        personaje.setHeridas(personajeDTO.getHeridas());
        personaje.setAtaque(personajeDTO.getAtaque());
        personaje.setDefensa(personajeDTO.getDefensa());
        return PersonajeMapper.toDTO(personajeRepository.save(personaje));
    }
}
