package com.ProyectoFinal.PathfinderBuilder.model;

//La clase Personaje tiene como objetivo instanciar los personajes que se van a crear en el juego. seran almacenados en la base de datos. los personajes podran interactuar entre ellos y luchar, perdiendo HP y al llegar a 0 quedaran fuera de combate hasta que se restaure su HP de alguna manera
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.FetchType;

import java.util.List;
import java.util.Random;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personajes")

public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dueñoDelPersonaje;
    private String nombre;
    private String profesion;
    private int hpTotal;
    private int heridas;
    private int ataque;
    private int defensa;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipo")
    private List<Equipo> equipo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_raza")
    private Raza raza;

//metodos

    public void atacarA(Personaje personaje) {
        Random rand = new Random();
        if (this.getAtaque()+(rand.nextInt(20)+1) > personaje.getDefensa()) {
            System.out.println("El personaje " + this.getNombre() + " ha golpeado a " + personaje.getNombre());
            personaje.setHeridas(personaje.getHeridas() + 1);
            } else {
                System.out.println("El personaje " + this.getNombre() + " ha fallado su ataque");
            }
        }
//pelear a muerte con un personaje --> se ataca varias veces a un personaje hasta que las heridas del personaje o las mismas superen sus puntos de vida

    public void pelearA(Personaje personaje) {
        while (personaje.getHeridas() <= personaje.getHpTotal() && this.getHeridas() <= this.getHpTotal()) {
            this.atacarA(personaje);
            personaje.atacarA(this);
        }
        if (personaje.getHeridas() >= personaje.getHpTotal()) {
            System.out.println("El personaje " + personaje.getNombre() + " ha muerto");
        } else {
            System.out.println("El personaje " + this.getNombre() + " ha muerto");
        }
    }

}
