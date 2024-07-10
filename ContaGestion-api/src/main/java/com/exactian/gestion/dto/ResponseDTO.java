package com.exactian.gestion.dto;

public class ResponseDTO {
    private boolean success;
    private String message;

    public ResponseDTO() {
    }

    public ResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

	public String getMessage() {
		return message;
	}

	public ResponseDTO setMessage(String message) {
		this.message = message;
		return this;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

    

}
