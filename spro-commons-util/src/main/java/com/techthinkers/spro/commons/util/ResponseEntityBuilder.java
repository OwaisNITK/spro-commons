package com.techthinkers.spro.commons.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.techthinkers.spro.commons.util.exception.SproErrorResponse;

public final class ResponseEntityBuilder {

	public static <T> ResponseEntity<SproApiResponse<T>> buildApiResponse(final T reponseBody, final HttpStatus httpStatusCode) {
		final SproApiResponse<T> sproApiResponse = new SproApiResponse<>(reponseBody);
		return ResponseEntity.status(httpStatusCode).body(sproApiResponse);
	}
	
	public static ResponseEntity<Object> buildApiErrorResponse(final SproErrorResponse sproErrorResponse) {
		final SproApiResponse sproApiResponse = new SproApiResponse(sproErrorResponse);
		return new ResponseEntity<>(sproApiResponse, sproApiResponse.getSproErrorResponse().getStatus());
	}
	
   public static <T> T getSproApiResponse(ResponseEntity<SproApiResponse<T>> responseEntity) {
	   final SproApiResponse<T> body = responseEntity.getBody();
       return body.getSproApiResponse();
   }
   
   private ResponseEntityBuilder() {
	    throw new IllegalStateException("Utility class");
	  }
}