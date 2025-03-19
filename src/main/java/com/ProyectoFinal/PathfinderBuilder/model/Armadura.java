package com.ProyectoFinal.PathfinderBuilder.model;

//subclase de Equipo. tiene como objetivo instanciar las distintas armaduras que podran poseer los personajes, las mismas tienen como objetivo aumentar la defensa del personaje para que sean mas dificil de ser heridos.
public class Armadura extends Equipo{
    //atributos
    private int defensa;
    //constructor
    public Armadura(String nombreEquipo, String descripcionEquipo, int defensa) {
        super(nombreEquipo, descripcionEquipo);
        this.defensa = defensa;
    }
    //getters
    public int getDefensa() {
        return defensa;
    }
    //setters
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
