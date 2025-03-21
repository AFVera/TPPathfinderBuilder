package com.ProyectoFinal.PathfinderBuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinal.PathfinderBuilder.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>{
    
}


