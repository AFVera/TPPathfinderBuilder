package com.ProyectoFinal.PathfinderBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ProyectoFinal.PathfinderBuilder.model.Arma;
import com.ProyectoFinal.PathfinderBuilder.model.Personaje;
import com.ProyectoFinal.PathfinderBuilder.service.PersonajeService;

@SpringBootApplication
public class PathfinderBuilderApplication implements CommandLineRunner {

	@Autowired PersonajeService personajeService;

	public static void main(String[] args) {
		SpringApplication.run(PathfinderBuilderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//creo un personaje
		Personaje personaje1 = Personaje.builder()
				.dueñoDelPersonaje("Javier")
				.nombre("Beto")
				.profesion("Cazador")
				.hpTotal(5)
				.heridas(0)
				.ataque(0)
				.defensa(10)
				.build();

		Personaje personaje2 = Personaje.builder()
				.dueñoDelPersonaje("Javier")
				.nombre("Bato")
				.profesion("Guerrero")
				.hpTotal(5)
				.heridas(0)
				.ataque(0)
				.defensa(10)
				.build();



		Arma espada = new Arma("Espada", "Una espada", "Cortante", 0, 5,1);
		Arma mazo = new Arma("Mazo", "Un mazo", "Contundente", 0, 6,1);
		Arma Lanza = new Arma("Lanza", "Una lanza", "Cortante", 0, 10,2);

		personajeService.save(personaje1);
		personajeService.save(personaje2);

		personaje1.pelearA(personaje2);
	}

	

}
