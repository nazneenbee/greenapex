package com.greenapex.Exception;


import java.net.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IdNotValidException.class)
	public ResponseEntity<?> handleIdNotValidException(IdNotValidException exception)
	{
		return new ResponseEntity<String>("Id Not Present",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataNotAvailableException.class)
	public ResponseEntity<?> handleDataNotAvailableException(DataNotAvailableException exception)
	{
		return new ResponseEntity<String>("data Not Present",HttpStatus.NOT_FOUND);
	}
	
}
