package com.exactian.gestion.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactian.gestion.dto.AsistenciaRequestDTO;
import com.exactian.gestion.dto.EgresoResponseDTO;
import com.exactian.gestion.dto.ResponseDTO;
import com.exactian.gestion.enums.MensajesRespuesta;
import com.exactian.gestion.model.Acceso;
import com.exactian.gestion.model.Empleado;
import com.exactian.gestion.repositories.AccesoRepository;
import com.exactian.gestion.repositories.EmpleadoRepository;

@Service
public class AsistenciaService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private AccesoRepository accesoRepository;
	
	
	public ResponseDTO registrarIngreso(AsistenciaRequestDTO request) {

		Empleado empleado = empleadoRepository.findById(request.getIdEmpleado()).orElse(null);

		ResponseDTO response = validarEmpleadoYEstado(empleado);
	    
		if (!response.isSuccess()){
			return response;
		}

		else if (empleado.getEstado().isDentro_compania()) {
			return new ResponseDTO(false, MensajesRespuesta.EMPLEADO_YA_ESTA_DENTRO.toString());
		}

		empleado.getEstado().setDentro_compania(true);
		empleado.getEstado().setHora_ult_ingreso(request.getFecha());
		empleado = empleadoRepository.save(empleado);

		Acceso acceso = new Acceso();
        acceso.setEmpleado(empleado); 
        acceso.setHora_acceso(new Date()); 
        acceso.setTipo_ingreso("INGRESO"); 
        acceso.setHora_registro(request.getFecha());
        accesoRepository.save(acceso);

		return new  ResponseDTO(true, MensajesRespuesta.INGRESO_REGISTRADO_CORRECTAMENTE.toString());
	}

	public EgresoResponseDTO registrarEgreso(AsistenciaRequestDTO request) {

		Empleado empleado = empleadoRepository.findById(request.getIdEmpleado()).orElse(null);

		/*
		EgresoResponseDTO response = validarempleadoYEstado(empleado);
    
		if (!response.isSuccess()){
			return response;
		}
*/
		if (!empleado.getEstado().isDentro_compania()) {
			return new EgresoResponseDTO(false, MensajesRespuesta.EMPLEADO_NO_ESTA_DENTRO.toString(),null);
		}
		
		long diferencia = request.getFecha().getTime() - empleado.getEstado().getHora_ult_ingreso().getTime();
		
		if (diferencia < 0) {
			return new EgresoResponseDTO(false, MensajesRespuesta.HORA_EGRESO_MENOR.toString(),null);
		}
		else if (diferencia == 0) {
			return new EgresoResponseDTO(false, MensajesRespuesta.HORA_EGRESO_IGUAL.toString(),null);
		}
		
		empleado.getEstado().setDentro_compania(false);
		empleado.getEstado().setHora_ult_egreso(request.getFecha());
		empleadoRepository.save(empleado);

		Acceso acceso = new Acceso();
        acceso.setEmpleado(empleado); 
        acceso.setHora_acceso(new Date()); 
        acceso.setTipo_ingreso("EGRESO"); 
        acceso.setHora_registro(request.getFecha());
        accesoRepository.save(acceso);


		return new EgresoResponseDTO(true, MensajesRespuesta.EGRESO_REGISTRADO_CORRECTAMENTE.toString(), diferencia);
	}



	private ResponseDTO validarEmpleadoYEstado(Empleado empleado) {
		/*
		if (empleado == null) {
			return new ResponseDTO(false, MensajesRespuesta.USUARIO_NO_ENCONTRADO.toString());
		} else if (empleado.getEmpleado() == null) {
			return new ResponseDTO(false, MensajesRespuesta.USUARIO_NO_TIENE_EMPLEADO.toString());
		} else if (empleado.getEmpleado().getEstado() == null) {
			return new ResponseDTO(false, MensajesRespuesta.EMPLEADO_NO_TIENE_ESTADO.toString());
		} */
		return new ResponseDTO(true, null);
	}
}
