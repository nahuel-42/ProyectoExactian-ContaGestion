package com.exactian.gestion.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String contrasena;

	@OneToOne()
	@JoinColumn(name = "id_empleado", unique = true, insertable = true, updatable = true)
	private Empleado empleado;

	@OneToOne()
	@JoinColumn(name = "id_rol", unique = true, insertable = true, updatable = true)
	private Rol roles;

	public Usuario(Long id_usuario, String username, String contrasena, Empleado empleado, Rol roles) {
		super();
		this.id_usuario = id_usuario;
		this.username = username;
		this.contrasena = contrasena;
		this.empleado = empleado;
		this.roles = roles;
	}

	public Usuario() {
		super();
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	
	public Rol getRoles() {
		return roles;
	}

	public void setRoles(Rol roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority((roles.getNombre())));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.contrasena;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
