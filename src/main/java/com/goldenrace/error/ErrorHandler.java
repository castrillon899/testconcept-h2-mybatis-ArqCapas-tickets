package com.goldenrace.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.goldenrace.exception.BadMessageException;
import com.goldenrace.exception.ResourceNotFoundException;

@ControllerAdvice
public class ErrorHandler {

	private static final ConcurrentHashMap<String, Integer> CODIGOS_DE_ERROR = new ConcurrentHashMap<>();
	private static final String ERROR_NO_CONTROLADO = "Error no controlado en tiempo de ejecucion";
	
	public ErrorHandler() {
		CODIGOS_DE_ERROR.put(ResourceNotFoundException.class.getSimpleName(),
				HttpStatus.BAD_REQUEST.value());
		CODIGOS_DE_ERROR.put(BadMessageException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_DE_ERROR.put(ResourceNotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
	}
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
		ResponseEntity<Error> resultado;

		String excepcionNombre = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGOS_DE_ERROR.get(excepcionNombre);

		if (codigo != null) {
			Error error = new Error(mensaje);
			resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		} else {
			Error error = new Error(ERROR_NO_CONTROLADO);
			resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resultado;
	}

}
