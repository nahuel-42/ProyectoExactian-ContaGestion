package com.exactian.gestion.model;

import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Rol {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_rol;
  

	@Column(nullable = false) 
	private String nombre;

    @Column()
    private String descripcion;

    @OneToOne (mappedBy = "roles", cascade = CascadeType.ALL)
	private Usuario usuario;
    
    
	public Rol(Long id_rol, String nombre, String descripcion) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
    
	public Rol() {
	}

	public Rol(String nombre, String descripcion) {
	    this.nombre = nombre;
	    this.descripcion = descripcion;
	}
	
	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
	
}
