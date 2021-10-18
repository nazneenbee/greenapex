package com.greenapex.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountControllerAdvice {

	@ExceptionHandler(value=NumberFormatException.class)
	public String dataBindException(NumberFormatException e)
	{
		return "error";                 
	}
	
	@ExceptionHandler(value=Exception.class)
	public String AnyException(Exception e)
	{
		return "error";
	}
}
