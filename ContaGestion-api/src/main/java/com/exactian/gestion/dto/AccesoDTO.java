package com.exactian.gestion.dto;

import java.util.Date;

public class AccesoDTO {
	
	private Long id_acceso;
	private Date hora_registro;
	private Date hora_acceso;
    private String tipo_ingreso;
    private EmpleadoDTO empleado;
    
    
	public AccesoDTO(Long id_acceso, Date hora_registro, Date hora_acceso, String tipo_ingreso, EmpleadoDTO empleado) {
		super();
		this.id_acceso = id_acceso;
		this.hora_registro = hora_registro;
		this.hora_acceso = hora_acceso;
		this.tipo_ingreso = tipo_ingreso;
		this.empleado = empleado;
	}


	public AccesoDTO() {
		super();
	}


	public Long getId_acceso() {
		return id_acceso;
	}


	public void setId_acceso(Long id_acceso) {
		this.id_acceso = id_acceso;
	}


	public Date getHora_registro() {
		return hora_registro;
	}


	public void setHora_registro(Date hora_registro) {
		this.hora_registro = hora_registro;
	}


	public Date getHora_acceso() {
		return hora_acceso;
	}


	public void setHora_acceso(Date hora_acceso) {
		this.hora_acceso = hora_acceso;
	}


	public String getTipo_ingreso() {
		return tipo_ingreso;
	}


	public void setTipo_ingreso(String tipo_ingreso) {
		this.tipo_ingreso = tipo_ingreso;
	}


	public EmpleadoDTO getEmpleado() {
		return empleado;
	}


	public void setEmpleado(EmpleadoDTO empleado) {
		this.empleado = empleado;
	}
    
    
    
    
}
