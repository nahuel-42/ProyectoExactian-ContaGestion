package com.exactian.gestion.dto;

public class RequestDTO {
    private String nombreDeUsuario;

    public RequestDTO() {
    }

    public RequestDTO(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }
}
