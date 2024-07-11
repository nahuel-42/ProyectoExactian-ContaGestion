package com.exactian.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exactian.gestion.model.Empleado;


public interface EmpleadoRepository  extends JpaRepository<Empleado, Long>{

}
