package com.exactian.gestion.dto;

import java.util.Date;
import java.util.List;

import com.exactian.gestion.model.Acceso;
import com.exactian.gestion.model.EstadoEmpleado;



public class EmpleadoDTO {

	private Long id_empleado;
    
    
	private String nombre;
	private String apellido;
	private String email;
	private EstadoEmpleadoDTO estado;
	List<Acceso> acceso;
	private Date hora_ult_egreso;
	
	

	public EmpleadoDTO(Long id_empleado, String nombre, String apellido, String email, EstadoEmpleadoDTO estado,
			List<Acceso> acceso, Date hora_ult_egreso) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.estado = estado;
		this.acceso = acceso;
		this.hora_ult_egreso = hora_ult_egreso;
	}

	public EmpleadoDTO() {
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

	public EstadoEmpleadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoEmpleadoDTO estado) {
		this.estado = estado;
	}

	public List<Acceso> getAcceso() {
		return acceso;
	}

	public void setAcceso(List<Acceso> acceso) {
		this.acceso = acceso;
	}

	public Date getHora_ult_egreso() {
		return hora_ult_egreso;
	}

	public void setHora_ult_egreso(Date hora_ult_egreso) {
		this.hora_ult_egreso = hora_ult_egreso;
	}
	


    

}
