package com.exactian.gestion.mapper;

import org.springframework.stereotype.Component;

import com.exactian.gestion.dto.EstadoEmpleadoDTO;
import com.exactian.gestion.model.EstadoEmpleado;

@Component
public class EstadoEmpleadoMapper {

	
	 public EstadoEmpleadoDTO toDTO(EstadoEmpleado entity) {
	        if ( entity == null ) {
	            return null;
	        }

	        EstadoEmpleadoDTO estadoEmpleadoDTO = new EstadoEmpleadoDTO();
	        estadoEmpleadoDTO.setDentro_compania( entity.isDentro_compania() );
	        estadoEmpleadoDTO.setHora_ult_ingreso(entity.getHora_ult_ingreso());
	        estadoEmpleadoDTO.setHora_ult_egreso(entity.getHora_ult_egreso());
	        estadoEmpleadoDTO.setId_estado(entity.getId_estado());
	        
	        return estadoEmpleadoDTO;
	    }
}
