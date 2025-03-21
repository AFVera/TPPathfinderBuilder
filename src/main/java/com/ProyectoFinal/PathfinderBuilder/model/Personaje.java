package com.ProyectoFinal.PathfinderBuilder.model;

//La clase Personaje tiene como objetivo instanciar los personajes que se van a crear en el juego. seran almacenados en la base de datos. los personajes podran interactuar entre ellos y luchar, perdiendo HP y al llegar a 0 quedaran fuera de combate hasta que se restaure su HP de alguna manera
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.FetchType;

import java.util.ArrayList;
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
    private Long id;
    private String dueñoDelPersonaje;
    private String nombre;
    private String profesion;
    private Integer hpTotal;
    private Integer heridas;
    private Integer ataque;
    private Integer defensa;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipo")
    private List<Equipo> equipo;


//metodos

    public String atacarA(Personaje personaje) {
        Random rand = new Random();
        if (this.getAtaque()+(rand.nextInt(20)+1) > personaje.getDefensa()) {
            personaje.setHeridas(personaje.getHeridas() + 1);
            return "El personaje " + this.getNombre() + " ha golpeado a " + personaje.getNombre();
            
            } else {
            return  "El personaje " + this.getNombre() + " ha fallado su ataque";
            }
        }
//pelear a muerte con un personaje --> se ataca varias veces a un personaje hasta que las heridas del personaje o las mismas superen sus puntos de vida

    public ArrayList<String> pelearA(Personaje personaje) {
        ArrayList<String> logPelea = new ArrayList<>();
        logPelea.add(this.getNombre() + " VS " + personaje.getNombre());
        logPelea.add(this.getNombre() + ": VIDA: " + this.getHpTotal() + " - ATAQUE: " + this.getAtaque() + " - DEFENSA: " + this.getDefensa());
        logPelea.add(personaje.getNombre() + ": VIDA: " + personaje.getHpTotal() + " - ATAQUE: " + personaje.getAtaque() + " - DEFENSA: " + personaje.getDefensa());
        while (personaje.getHeridas() <= personaje.getHpTotal() && this.getHeridas() <= this.getHpTotal()) {
           logPelea.add(this.atacarA(personaje));
           if (personaje.getHeridas() >= personaje.getHpTotal()) {
               break;
           } else {logPelea.add(personaje.atacarA(this));
        }   
        }
        if (personaje.getHeridas() >= personaje.getHpTotal()) {
            logPelea.add("El personaje " + personaje.getNombre() + " ha muerto");;
        } else {
            logPelea.add("El personaje " + this.getNombre() + " ha muerto");
        }
        return logPelea;
    }

}
