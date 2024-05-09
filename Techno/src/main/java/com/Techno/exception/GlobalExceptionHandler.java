package com.Techno.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {

		// Extract field names and message templates from ConstraintViolationException
		List<Map<String, String>> errors = ex.getConstraintViolations().stream().map(violation -> {
			Map<String, String> error = new HashMap<>();
			error.put(violation.getPropertyPath().toString(), violation.getMessageTemplate());
			return error;
		}).collect(Collectors.toList());

		Map<String, Object> response = new HashMap<>();
		response.put("errors", errors);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {

		// Create a response entity with an error message and HTTP status
		Map<String, Object> response = new HashMap<>();
		response.put("message", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
