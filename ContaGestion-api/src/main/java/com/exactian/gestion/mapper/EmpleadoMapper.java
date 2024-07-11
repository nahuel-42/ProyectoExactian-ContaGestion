package com.exactian.gestion.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exactian.gestion.dto.EmpleadoDTO;
import com.exactian.gestion.model.Empleado;

@Component
public class EmpleadoMapper {


	@Autowired
	EstadoEmpleadoMapper estadoEmpleadoMapper;
	
	 public EmpleadoDTO toDTO(Empleado entity) {
	        if ( entity == null ) {
	            return null;
	        }
	        entity.setAcceso(null);
	        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
	        empleadoDTO.setAcceso( entity.getAcceso() );
	        empleadoDTO.setApellido(entity.getApellido());
	        empleadoDTO.setEmail(entity.getEmail());
	        empleadoDTO.setEstado(estadoEmpleadoMapper.toDTO(entity.getEstado()));
	        empleadoDTO.setId_empleado(entity.getId_empleado());
	        empleadoDTO.setNombre(entity.getNombre());
	        return empleadoDTO;
	    }
}

	 
