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
    private String apellido;

    @ManyToMany
    @JoinTable(name = "Usuarios_tienen_rol",
               joinColumns = @JoinColumn(name = "id_rol"),
               inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List <Usuario> usuarios;
    
    
	public Rol(Long id_rol, String nombre, String apellido) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.apellido = apellido;
	}
    
	public Rol() {
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
    
	
}
