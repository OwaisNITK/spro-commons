package com.techthinkers.spro.commons.util.exception;

import java.util.Arrays;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.techthinkers.spro.commons.util.ResponseEntityBuilder;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class SproExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception ex) {
		final String errorMsg = "Exception occured while trying to perform spro operation";
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.errorCode(ErrorCode.GEN_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}

	@ExceptionHandler(SproBusinessException.class)
	public ResponseEntity<Object> handleSproBusinessException(SproBusinessException ex) {
		final String errorMsg = "Something Went Wrong, but exception handled by SproExceptionHandler";
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.errorCode(ErrorCode.GEN_EXCEPTION.name())
				.message(errorMsg).build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.METHOD_NOT_ALLOWED)
				.errorCode(ErrorCode.HTTP_METHOD_NOT_SUPPORTED_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
				.errorCode(ErrorCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
			HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.NOT_ACCEPTABLE)
				.errorCode(ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(
			MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.errorCode(ErrorCode.MISSING_PATH_VARIABLE_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.errorCode(ErrorCode.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(
			MissingServletRequestPartException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.errorCode(ErrorCode.MISSING_SERVLET_REQUEST_PART_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(
			ServletRequestBindingException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.errorCode(ErrorCode.SERVLET_REQUEST_BINDING_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.errorCode(ErrorCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleHandlerMethodValidationException(
			HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.errorCode(ErrorCode.HANDLER_METHOD_VALIDATION_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(
			NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.NOT_FOUND)
				.errorCode(ErrorCode.NO_HANDLER_FOUND_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoResourceFoundException(
			NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.NOT_FOUND)
				.errorCode(ErrorCode.NO_RESOURCE_FOUND_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(
			AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.SERVICE_UNAVAILABLE)
				.errorCode(ErrorCode.ASYNC_REQUEST_TIMEOUT_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleErrorResponseException(
			ErrorResponseException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.errorCode(ErrorCode.ERROR_RESPONSE_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleMaxUploadSizeExceededException(
			MaxUploadSizeExceededException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.PAYLOAD_TOO_LARGE)
				.errorCode(ErrorCode.MAX_UPLOAD_SIZE_EXCEEDED_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(
			ConversionNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Object[] args = {ex.getPropertyName(), ex.getValue()};
		final String errorMsg = "Failed to convert '" + args[0] + "' with value: '" + args[1] + "'";
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.errorCode(ErrorCode.CONVERSION_NOT_SUPPORTED_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(
			TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Object[] args = {ex.getPropertyName(), ex.getValue()};
		final String errorMsg = "Failed to convert '" + args[0] + "' with value: '" + args[1] + "'";
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.errorCode(ErrorCode.TYPE_MISMATCH_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {		
		String errorMsg = null;
		if (ex.getCause() instanceof InvalidFormatException) {
			final InvalidFormatException ifx = (InvalidFormatException) ex.getCause();
			if (ifx.getTargetType() != null && ifx.getTargetType().isEnum()) {
				errorMsg = String.format("Invalid enum value: '%s' for the field: '%s'. The value must be one of :: %s.",
						ifx.getValue(), ifx.getPath().get(ifx.getPath().size() - 1).getFieldName(),
						Arrays.toString(ifx.getTargetType().getEnumConstants()));
			}
		} else {
			errorMsg = ex.getMessage();
		}
		
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.errorCode(ErrorCode.HTTP_MESSAGE_NOT_READABLE_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(
			HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.errorCode(ErrorCode.HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleBindException(
			BindException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.errorCode(ErrorCode.BIND_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodValidationException(
			MethodValidationException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		final String errorMsg = ex.getMessage();
		log.error(errorMsg);
		SproErrorResponse errorResponse = SproErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.errorCode(ErrorCode.METHOD_VALIDATION_EXCEPTION.name())
				.message(errorMsg)
				.build();
		return ResponseEntityBuilder.buildApiErrorResponse(errorResponse);
	}
}