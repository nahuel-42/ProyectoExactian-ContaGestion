package com.exactian.gestion.dto;

import java.util.Date;

import com.exactian.gestion.enums.TipoAsistencia;

public class AsistenciaRequestDTO extends RequestDTO{
    private Date fecha;
    private TipoAsistencia tipo;

    public AsistenciaRequestDTO() {
    }

	public AsistenciaRequestDTO(Date fecha, TipoAsistencia tipo) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
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

    



}
