package com.exactian.gestion.dto;

import lombok.Builder;

@Builder
public class AuthResponseDTO {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthResponseDTO(String token) {
		super();
		this.token = token;
	}
	
	
}
