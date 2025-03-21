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
    // metodo para guardar un personaje en la base de datos
    public Personaje save(Personaje personaje) {
        return personajeRepository.save(personaje);
    }
    // metodo para obtener todos los personajes
    public List<PersonajeResponse> getAllPersonajes() {
        return personajeRepository.findAll().stream().map(PersonajeMapper::toDTO).toList();
    }
    // metodo para crear un personaje
    public PersonajeResponse savePersonaje(PersonajeRequest personaje) {
        return PersonajeMapper.toDTO(personajeRepository.save(PersonajeMapper.toEntity(personaje)));
    }
    // metodo para actualizar un personaje
    public PersonajeResponse actualizarPersonaje(Long id, PersonajeRequest personaje2) {
        Personaje personaje = personajeRepository.findById(id).orElse(null);
        personaje.setDueñoDelPersonaje(personaje2.getDueñoDelPersonaje());
        personaje.setNombre(personaje2.getNombre());
        personaje.setProfesion(personaje2.getProfesion());
        personaje.setHpTotal(personaje2.getHpTotal());
        personaje.setHeridas(personaje2.getHeridas());
        personaje.setAtaque(personaje2.getAtaque());
        personaje.setDefensa(personaje2.getDefensa());
        return PersonajeMapper.toDTO(personajeRepository.save(personaje));
    }

    public Object borrarPersonaje(Long id) {
        personajeRepository.deleteById(id);
        return "Personaje borrado";
    }
      
}
