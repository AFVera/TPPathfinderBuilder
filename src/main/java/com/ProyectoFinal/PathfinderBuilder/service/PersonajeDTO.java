package com.ProyectoFinal.PathfinderBuilder.service;

import lombok.Builder;
import lombok.Data;

//DTO de la clase Personaje
@Data
@Builder
public class PersonajeDTO {
    private long id;
    private String dueñoDelPersonaje;
    private String nombre;
    private String profesion;
    private int hpTotal;
    private int heridas;
    private int ataque;
    private int defensa;

}
