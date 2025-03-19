package com.ProyectoFinal.PathfinderBuilder.model;

//La clase Raza tiene como objetivo modificar a los personajes para darles habilidades y caracteristicas distintas segun la raza que se elija

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "raza")
public class Raza {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tipo;
    private String descripcion;
    
    //constructor
    public Raza(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    //getters
    public String getRaza() {
        return this.tipo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    //setters
    public void setRaza(String tipo) {
        this.tipo = tipo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
