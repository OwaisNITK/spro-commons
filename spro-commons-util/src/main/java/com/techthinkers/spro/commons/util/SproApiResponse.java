package com.techthinkers.spro.commons.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techthinkers.spro.commons.util.exception.SproErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SproApiResponse<T> {

	private SproErrorResponse sproErrorResponse;

	private T sproApiResponse;
	
	public SproApiResponse(final SproErrorResponse sproErrorResponse) {
		this.sproErrorResponse = sproErrorResponse;
	}
	
	public SproApiResponse(final T responseBody) {
		this.sproApiResponse = responseBody;
	}
}