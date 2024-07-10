package com.exactian.gestion.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exactian.gestion.model.Rol;

@Repository
public interface RolRepository  extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByNombre(String nombre);
	
}
