package com.assignment.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WarehouseExceptionHandler {
	
	@ExceptionHandler(WarehouseException.class)
	public ResponseEntity<String> handleWarehouseException(WarehouseException ex) {
		
		switch (ex.getErrorCode()) {
		
		case "BAD_REQUEST":
			return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
		case "NOT_FOUND":
			return new ResponseEntity<>("NOT_FOUND", HttpStatus.NOT_FOUND);	
		case "NO_CONTENT":
			return new ResponseEntity<>("NO_CONTENT", HttpStatus.NO_CONTENT);	
		default:
			return new ResponseEntity<>("NOT_AVAILABLE", HttpStatus.NOT_IMPLEMENTED);

		}
	
	}	
	
	@ExceptionHandler
	public ResponseEntity<String> handleOtherException(Exception exception) {
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		
    }
	


}
