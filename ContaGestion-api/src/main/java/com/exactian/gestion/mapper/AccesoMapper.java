package com.exactian.gestion.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exactian.gestion.dto.AccesoDTO;

import com.exactian.gestion.model.Acceso;

@Component
public class AccesoMapper {


	@Autowired
	EmpleadoMapper empleadoMapper;
	
	 public AccesoDTO toDTO(Acceso entity) {
	        if ( entity == null ) {
	            return null;
	        }
	        entity.getEmpleado().setAcceso(null);
	        AccesoDTO accesoDTO = new AccesoDTO();
	        accesoDTO.setEmpleado( empleadoMapper.toDTO(entity.getEmpleado()));
	        accesoDTO.setHora_acceso(entity.getHora_acceso());
	        accesoDTO.setHora_registro(entity.getHora_registro());
	        accesoDTO.setId_acceso(entity.getId_acceso());
	        accesoDTO.setTipo_ingreso(entity.getTipo_ingreso());
	        return accesoDTO;
	    }
}

	 
