package com.exactian.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactian.gestion.dto.AsistenciaRequestDTO;
import com.exactian.gestion.dto.AsistenciaResponseDTO;
import com.exactian.gestion.dto.ResponseDTO;
import com.exactian.gestion.enums.MensajesRespuesta;
import com.exactian.gestion.model.Usuario;
import com.exactian.gestion.repositories.UsuarioRepository;

@Service
public class AsistenciaService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public ResponseDTO registrarIngreso(AsistenciaRequestDTO request) {

		Usuario usuario = usuarioRepository.findByUsername(request.getNombreDeUsuario()).orElse(null);

		ResponseDTO response = validarUsuarioYEstado(usuario);
	    
		if (!response.isSuccess()){
			return response;
		}

		else if (usuario.getEmpleado().getEstado().isDentro_compania()) {
			return new ResponseDTO(false, MensajesRespuesta.EMPLEADO_YA_ESTA_DENTRO.toString());
		}

		usuario.getEmpleado().getEstado().setDentro_compania(true);
		usuario.getEmpleado().getEstado().setHola_ult_ingreso(request.getFecha());
		usuarioRepository.save(usuario);

		return new  ResponseDTO(true, MensajesRespuesta.INGRESO_REGISTRADO_CORRECTAMENTE.toString());
	}

	public ResponseDTO registrarEgreso(AsistenciaRequestDTO request) {

		Usuario usuario = usuarioRepository.findByUsername(request.getNombreDeUsuario()).orElse(null);

		ResponseDTO response = validarUsuarioYEstado(usuario);
    
		if (!response.isSuccess()){
			return response;
		}

		if (!usuario.getEmpleado().getEstado().isDentro_compania()) {
			return new ResponseDTO(false, MensajesRespuesta.EMPLEADO_NO_ESTA_DENTRO.toString());
		}
		
		usuario.getEmpleado().getEstado().setDentro_compania(false);
		usuario.getEmpleado().getEstado().setHola_ult_ingreso(request.getFecha());
		usuarioRepository.save(usuario);

		return new ResponseDTO(true, MensajesRespuesta.EGRESO_REGISTRADO_CORRECTAMENTE.toString());
	}



	private ResponseDTO validarUsuarioYEstado(Usuario usuario) {
		if (usuario == null) {
			return new ResponseDTO(false, MensajesRespuesta.USUARIO_NO_ENCONTRADO.toString());
		} else if (usuario.getEmpleado() == null) {
			return new ResponseDTO(false, MensajesRespuesta.USUARIO_NO_TIENE_EMPLEADO.toString());
		} else if (usuario.getEmpleado().getEstado() == null) {
			return new ResponseDTO(false, MensajesRespuesta.EMPLEADO_NO_TIENE_ESTADO.toString());
		} 
		return new ResponseDTO(true, null);
	}
}
