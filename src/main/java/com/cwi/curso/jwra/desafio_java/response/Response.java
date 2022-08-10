package com.cwi.curso.jwra.desafio_java.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {
	private int status;
	private String message;
	private T data;
	
}
