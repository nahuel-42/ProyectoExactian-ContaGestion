package com.exactian.gestion.dto;

import java.util.List;

import com.exactian.gestion.model.Acceso;
import com.exactian.gestion.model.EstadoEmpleado;
import com.exactian.gestion.model.Usuario;



public class EmpleadoDTO {

public class Empleado {

	private Long id_empleado;
    
    
	private String nombre;
	private String apellido;
	private String email;
	private EstadoEmpleado estado;
	private Usuario usuario;
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

}
