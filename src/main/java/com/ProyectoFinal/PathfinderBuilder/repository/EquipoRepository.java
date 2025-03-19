package com.ProyectoFinal.PathfinderBuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinal.PathfinderBuilder.model.Equipo;



@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

}
