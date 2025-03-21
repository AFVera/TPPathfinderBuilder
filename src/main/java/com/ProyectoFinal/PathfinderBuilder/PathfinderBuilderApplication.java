package com.ProyectoFinal.PathfinderBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
				.nombre("Caza-Dor")
				.profesion("Cazador")
				.hpTotal(5)
				.heridas(0)
				.ataque(5)
				.defensa(12)
				.build();

		Personaje personaje2 = Personaje.builder()
				.dueñoDelPersonaje("Javier")
				.nombre("Warrior")
				.profesion("Guerrero")
				.hpTotal(6)
				.heridas(0)
				.ataque(2)
				.defensa(14)
				.build();

		personajeService.save(personaje1);
		personajeService.save(personaje2);
	}

	

}
