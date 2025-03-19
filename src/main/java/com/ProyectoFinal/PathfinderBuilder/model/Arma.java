package com.ProyectoFinal.PathfinderBuilder.model;

//subclase de Equipo. tiene como objetivo instanciar las armas que podran posser los personajes. las armas tendran una bonificacion de ataque y daño, y cuantas manos disponibles necesita el personaje para manipularla
public class Arma extends Equipo {
    //atributos
    private String tipo;
    private int mano;
    private int ataque;
    private int daño;
    //constructor
    public Arma(String nombreEquipo, String descripcionEquipo,String tipo, int ataque, int daño, int mano) {
            super(nombreEquipo, descripcionEquipo);
            this.tipo = tipo;
            this.mano = mano;
        this.ataque = ataque;
        this.daño = daño;
    }
    //getters
    public String getTipo() {
        return tipo;
    }
    public int getMano() {
        return mano;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getDanio() {
        return daño;
    }
    //setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setMano(int mano) {
        this.mano = mano;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public void setDanio(int daño) {
        this.daño = daño;
    }

}
