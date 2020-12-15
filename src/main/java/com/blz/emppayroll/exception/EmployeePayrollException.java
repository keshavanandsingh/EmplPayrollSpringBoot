package com.blz.emppayroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blz.emppayroll.dto.ResponseDTO;

@RestControllerAdvice
public class EmployeePayrollException {
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<String> globalEmployeeException(EmployeeException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseDTO> AnonymousException(Exception e) {
		ResponseDTO status2 = new ResponseDTO("Exception thrown!! Can't process your request.", e.getMessage());
		return new ResponseEntity<ResponseDTO>(status2, HttpStatus.BAD_REQUEST);
	}
}
