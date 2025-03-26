package com.ProyectoFinal.PathfinderBuilder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoFinal.PathfinderBuilder.dto.PersonajeRequest;
import com.ProyectoFinal.PathfinderBuilder.dto.PersonajeResponse;
import com.ProyectoFinal.PathfinderBuilder.mapper.PersonajeMapper;
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
    // metodo para borrar un personaje
    public String borrarPersonaje(Long id) {
        personajeRepository.deleteById(id);
        return "Personaje borrado";
    }
    // metodo que trae 2 personajes y lo hacen pelear entre ellos
    public ArrayList<String> pelearPersonajes(Long id1, Long id2) {
        Personaje p1 = personajeRepository.findById(id1).orElse(null);
        Personaje p2 = personajeRepository.findById(id2).orElse(null);
        return p1.pelearA(p2);
        
    }
      
}
