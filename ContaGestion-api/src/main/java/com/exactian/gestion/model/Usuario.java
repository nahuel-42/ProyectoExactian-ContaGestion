package com.exactian.gestion.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_usuario;
    
	@Column(nullable = false) 
	private String nombre_de_usuario;

    @Column(nullable = false)
    private String contrasena;

    @OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empleado", unique = true, insertable = true, updatable = true)
    private Empleado empleado;

    @ManyToMany(mappedBy = "usuarios")
    private List <Rol> roles;
   
	public Usuario(Long id_usuario, String nombre_de_usuario, String contrasena, Empleado empleado) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_de_usuario = nombre_de_usuario;
		this.contrasena = contrasena;
		this.empleado = empleado;
	}


	public Usuario() {
		
	}


	public Long getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getNombre_de_usuario() {
		return nombre_de_usuario;
	}


	public void setNombre_de_usuario(String nombre_de_usuario) {
		this.nombre_de_usuario = nombre_de_usuario;
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
	
	
}
