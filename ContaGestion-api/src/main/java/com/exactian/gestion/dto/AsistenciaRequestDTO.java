package com.exactian.gestion.dto;

import java.util.Date;

import com.exactian.gestion.enums.TipoAsistencia;

public class AsistenciaRequestDTO extends RequestDTO{
    private Date fecha;
    private TipoAsistencia tipo;
    private Long idEmpleado;

    public AsistenciaRequestDTO() {
    }


	public AsistenciaRequestDTO(Date fecha, TipoAsistencia tipo, Long idEmpleado) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
		this.idEmpleado = idEmpleado;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TipoAsistencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoAsistencia tipo) {
		this.tipo = tipo;
	}


	public Long getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

    



}
