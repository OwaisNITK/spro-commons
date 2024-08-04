package com.techthinkers.spro.commons.util.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@JsonIgnoreProperties({"cause","stackTrace","localizedMessage","message","suppressed"})
@AllArgsConstructor
@Data
public class SproBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final transient SproErrorResponse sproErrorResponse;
	
}