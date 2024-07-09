package com.exactian.gestion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accesos")
public class Acceso {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_acceso;
	
	@Column(nullable = false) 
	private Date hora_registro;

	@Column(nullable = false) 
	private Date hora_acceso;

    @Column(nullable = false) 
    private String tipo_ingreso;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    
	public Acceso(Long id_acceso, Date hora_registro, Date hora_acceso, String tipo_ingreso) {
		super();
		this.id_acceso = id_acceso;
		this.hora_registro = hora_registro;
		this.hora_acceso = hora_acceso;
		this.tipo_ingreso = tipo_ingreso;
	}

	public Acceso() {
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

	
	
	

}
