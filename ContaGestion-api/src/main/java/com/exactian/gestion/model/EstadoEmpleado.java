package com.exactian.gestion.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estado_empleados")
public class EstadoEmpleado {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_estado;
	

	@Column(nullable = false) 
	private Date hora_ult_ingreso;
	

	private Date hora_ult_egreso;
	
	@Column(nullable = false) 
	private boolean dentro_compania;

	@OneToOne(mappedBy = "estado", cascade = CascadeType.ALL)
    private Empleado empleado;

	public EstadoEmpleado(Long id_estado, Date hora_ult_ingreso, Date hora_ult_egreso, boolean dentro_compania,
			Empleado empleado) {
		super();
		this.id_estado = id_estado;
		this.hora_ult_ingreso = hora_ult_ingreso;
		this.hora_ult_egreso = hora_ult_egreso;
		this.dentro_compania = dentro_compania;
		this.empleado = empleado;
	}

	public EstadoEmpleado() {
		super();
	}

	public Long getId_estado() {
		return id_estado;
	}

	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}


	public boolean isDentro_compania() {
		return dentro_compania;
	}

	public void setDentro_compania(boolean dentro_compania) {
		this.dentro_compania = dentro_compania;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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

	
	
	
}
