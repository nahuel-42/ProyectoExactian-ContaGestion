package com.exactian.gestion.dto;

public class LoginRequestDTO {

	private String nombre_de_usuario;
	private String contrasenia;
	
	public LoginRequestDTO(String nombre_de_usuario, String contrasenia) {
		super();
		this.nombre_de_usuario = nombre_de_usuario;
		this.contrasenia = contrasenia;
	}
	public String getNombre_de_usuario() {
		return nombre_de_usuario;
	}
	public void setNombre_de_usuario(String nombre_de_usuario) {
		this.nombre_de_usuario = nombre_de_usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
