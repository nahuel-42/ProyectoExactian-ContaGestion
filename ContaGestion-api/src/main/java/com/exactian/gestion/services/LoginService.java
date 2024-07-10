package com.exactian.gestion.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exactian.gestion.dto.AuthResponseDTO;
import com.exactian.gestion.dto.LoginRequestDTO;
import com.exactian.gestion.dto.RegistroRequestDTO;
import com.exactian.gestion.model.Empleado;
import com.exactian.gestion.model.EstadoEmpleado;
import com.exactian.gestion.model.Rol;
import com.exactian.gestion.model.Usuario;
import com.exactian.gestion.repositories.EmpleadoRepository;
import com.exactian.gestion.repositories.RolRepository;
import com.exactian.gestion.repositories.UsuarioRepository;
import com.exactian.gestion.security.jwt.JwtService;


@Service
public class LoginService {

	@Autowired
	private UsuarioRepository usuarioRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private RolRepository rolRepository;

	@Autowired
    private JwtService jwtService;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNombre_de_usuario(), request.getContrasenia()));
        UserDetails user=usuarioRepository.findByUsername(request.getNombre_de_usuario()).orElseThrow();
        String token=jwtService.getToken(user);
        return new AuthResponseDTO(token);

    }
    @Transactional
    public AuthResponseDTO register(RegistroRequestDTO request) {
        Rol rol = rolRepository.findByNombre("USER").orElse(null);
    	
        EstadoEmpleado estado = new EstadoEmpleado();
        estado.setDentro_compania(false);
        estado.setHola_ult_ingreso(new Date());
        
        Empleado empleado = new Empleado();
        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());   
        empleado.setEmail(request.getEmail());
        empleado = empleadoRepository.save(empleado); 
        empleado.setEstado(estado);
        
        Usuario usuario = new Usuario();
        usuario.setusername(request.getNombre_usuario());
        usuario.setContrasena(passwordEncoder.encode(request.getContrasenia()));
        usuario.setEmpleado(empleado);
        usuario.setRoles(rol);
 
    
        usuarioRepository.save(usuario);
        String token=jwtService.getToken(usuario);
        return new AuthResponseDTO(token);
        
    }
}
