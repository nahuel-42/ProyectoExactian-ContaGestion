package com.exactian.gestion.dto;

import java.util.Date;


public class EstadoEmpleadoDTO {

	private Long id_estado;
	private Date hora_ult_ingreso;
	private Date hora_ult_egreso;
	private boolean dentro_compania;
	
	public EstadoEmpleadoDTO(Long id_estado, Date hora_ult_ingreso, Date hora_ult_egreso, boolean dentro_compania) {
		super();
		this.id_estado = id_estado;
		this.hora_ult_ingreso = hora_ult_ingreso;
		this.hora_ult_egreso = hora_ult_egreso;
		this.dentro_compania = dentro_compania;
	}
	
	public EstadoEmpleadoDTO() {
		super();
	}


	public Long getId_estado() {
		return id_estado;
	}

	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}

	public Date getHora_ult_ingreso() {
		return hora_ult_ingreso;
	}

	public void setHora_ult_ingreso(Date hora_ult_ingreso) {
		this.hora_ult_ingreso = hora_ult_ingreso;
	}

	public Date getHora_ult_egreso() {
		return hora_ult_egreso;
	}

	public void setHora_ult_egreso(Date hora_ult_egreso) {
		this.hora_ult_egreso = hora_ult_egreso;
	}

	public boolean isDentro_compania() {
		return dentro_compania;
	}

	public void setDentro_compania(boolean dentro_compania) {
		this.dentro_compania = dentro_compania;
	}
	
	
}
