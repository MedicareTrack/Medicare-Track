package com.app.exc_handler;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.DTO.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		//System.out.println("in global handler : method arg invalid");
		Map<String, String> errorMap = ex.getFieldErrors().stream() // Stream<FieldError>
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ApiResponse handleRuntimeException(RuntimeException ex) {
		return new ApiResponse(ex.getMessage());
	}


	
}
