package com.exactian.gestion.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleados")
public class Empleado {


    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_empleado;
    
    
	@Column(nullable = false) 
	private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false) 
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado")
    private EstadoEmpleado estado;

	@OneToOne (mappedBy = "empleado", cascade = CascadeType.ALL)
	private Usuario usuario;

	@OneToMany(mappedBy = "empleado")
    List<Acceso> acceso;

	public Empleado(Long id_empleado, String nombre, String apellido, String email, EstadoEmpleado estado,
			Usuario usuario, List<Acceso> acceso) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.estado = estado;
		this.usuario = usuario;
		this.acceso = acceso;
	}

	public Empleado() {
		super();
	}

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EstadoEmpleado getEstado() {
		return estado;
	}

	public void setEstado(EstadoEmpleado estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Acceso> getAcceso() {
		return acceso;
	}

	public void setAcceso(List<Acceso> acceso) {
		this.acceso = acceso;
	}
	


    
}
