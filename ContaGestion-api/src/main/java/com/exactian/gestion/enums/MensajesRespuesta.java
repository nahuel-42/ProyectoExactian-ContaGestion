package com.exactian.gestion.enums;

public enum MensajesRespuesta {
	
	INGRESO_REGISTRADO_CORRECTAMENTE("Ingreso registrado correctamente."),
    EGRESO_REGISTRADO_CORRECTAMENTE("Egreso registrado correctamente."),
    ERROR_REGISTRO_INGRESO("No se pudo registrar el ingreso debido a condiciones no cumplidas."),
    USUARIO_NO_ENCONTRADO("Usuario no encontrado."),
    USUARIO_NO_TIENE_EMPLEADO("El usuario no tiene un empleado asociado."),
    EMPLEADO_NO_TIENE_ESTADO("El empleado no tiene un estado asociado."),
    EMPLEADO_NO_ESTA_DENTRO("El empleado no se encuentra dentro de la compañía."),
    EMPLEADO_YA_ESTA_DENTRO("El empleado ya se encuentra dentro de la compañía."),
	HORA_EGRESO_MENOR("La fecha de ingreso indicada es anterior a la fecha de ingreso"),
	HORA_EGRESO_IGUAL("La fecha de ingreso indicada es igual a la fecha de ingreso");
    private final String message;

    MensajesRespuesta(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
