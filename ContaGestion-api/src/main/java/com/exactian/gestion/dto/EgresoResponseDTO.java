package com.exactian.gestion.dto;

public class EgresoResponseDTO extends ResponseDTO{
	private Long horaTranscurrida;

	public EgresoResponseDTO() {
		super();
	}

	public EgresoResponseDTO(boolean success, String message,Long horaTranscurrida) {
		super(success, message);
		this.horaTranscurrida = horaTranscurrida;
	}


	public Long getHoraTranscurrida() {
		return horaTranscurrida;
	}

	public void setHoraTranscurrida(Long horaTranscurrida) {
		this.horaTranscurrida = horaTranscurrida;
	}
	
	
}
