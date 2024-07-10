package com.exactian.gestion.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactian.gestion.model.Usuario;
import com.exactian.gestion.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
		return usuarioRepository.findByUsername(nombreUsuario);
	}
	
	
	public void save (Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
