package com.techthinkers.spro.commons.util.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SproErrorResponse {

	@Schema(description = "Error Code Associated with Operation" , name = "errorCode", required = true, example = "SPRO_ERROR")
	@NotBlank
	private String errorCode;
	
	@Schema(description = "Error Message Associated with Exception" , name = "errorMessage", required = true, example = "Null Pointer Exception")
	@NotBlank
	private String message ;
	
	@Schema(description = "HTTPStatusCode" , name = "status", required = true, example = "200 OK")
	@NotBlank
	private HttpStatus status;
}
