package com.cwi.curso.jwra.desafio_java.utils;

public class ApiErroException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3974397391002395100L;
	private String message;
	public String getMessage() {
		return message;
	}
	public ApiErroException(String message) {
		this.message = message;
	}
	
}
