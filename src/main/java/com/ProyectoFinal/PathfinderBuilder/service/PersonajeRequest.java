package com.ProyectoFinal.PathfinderBuilder.service;

import lombok.Builder;
import lombok.Data;

//DTO de la clase Personaje
@Data
@Builder
public class PersonajeRequest  {
    private String dueñoDelPersonaje;
    private String nombre;
    private String profesion;
    private Integer hpTotal;
    private Integer heridas;
    private Integer ataque;
    private Integer defensa;

}
