package com.ProyectoFinal.PathfinderBuilder.service;

import org.springframework.stereotype.Component;

import com.ProyectoFinal.PathfinderBuilder.model.Personaje;

//Map de Personaje
@Component
public class PersonajeMapper {

    public static PersonajeResponse toDTO(Personaje personaje) {
        return PersonajeResponse.builder()
                .id(personaje.getId())
                .dueñoDelPersonaje(personaje.getDueñoDelPersonaje())
                .nombre(personaje.getNombre())
                .profesion(personaje.getProfesion())
                .hpTotal(personaje.getHpTotal())
                .heridas(personaje.getHeridas())
                .ataque(personaje.getAtaque())
                .defensa(personaje.getDefensa())
                .build();
    }

    public static Personaje toEntity(PersonajeResponse personajeDTO) {
        return Personaje.builder()
                .id(personajeDTO.getId())
                .dueñoDelPersonaje(personajeDTO.getDueñoDelPersonaje())
                .nombre(personajeDTO.getNombre())
                .profesion(personajeDTO.getProfesion())
                .hpTotal(personajeDTO.getHpTotal())
                .heridas(personajeDTO.getHeridas())
                .ataque(personajeDTO.getAtaque())
                .defensa(personajeDTO.getDefensa())
                .build();
    }

    public static Personaje toEntity(PersonajeRequest personaje) {
        return Personaje.builder()
                .dueñoDelPersonaje(personaje.getDueñoDelPersonaje())
                .nombre(personaje.getNombre())
                .profesion(personaje.getProfesion())
                .hpTotal(personaje.getHpTotal())
                .heridas(personaje.getHeridas())
                .ataque(personaje.getAtaque())
                .defensa(personaje.getDefensa())
                .build();
    }
}
