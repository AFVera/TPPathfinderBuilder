package com.ProyectoFinal.PathfinderBuilder.model;

//La clase Equipo tiene como objetivo instanciar los objetos que poseeran los personajes. seran almacenados en la base de datos.

import jakarta.persistence.*;
@Entity
@Table(name = "equipos")
public abstract class Equipo {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private long id;

    @Column(name = "nombre_equipo")
    private String nombreEquipo;

    @Column(name = "descripcion_equipo")
    private String descripcionEquipo;
    //constructor
    public Equipo(String nombreEquipo, String descripcionEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.descripcionEquipo = descripcionEquipo;
    }
    //getters
    public String getNombreEquipo() {
        return this.nombreEquipo;
    }
    public String getDescripcionEquipo() {
        return this.descripcionEquipo;    
    }
    //setters
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }
}
