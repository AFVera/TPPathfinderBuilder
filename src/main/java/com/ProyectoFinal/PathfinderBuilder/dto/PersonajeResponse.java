package com.ProyectoFinal.PathfinderBuilder.dto;

import lombok.Builder;
import lombok.Data;

//DTO de la clase Personaje
@Data
@Builder
public class PersonajeResponse {
    private Long id;
    private String dueñoDelPersonaje;
    private String nombre;
    private String profesion;
    private Integer hpTotal;
    private Integer heridas;
    private Integer ataque;
    private Integer defensa;

}
