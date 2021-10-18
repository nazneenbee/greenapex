package com.greenapex.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class IdNotValidException extends RuntimeException {
	private String errorCode;
	private String errprMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrprMessage() {
		return errprMessage;
	}
	public void setErrprMessage(String errprMessage) {
		this.errprMessage = errprMessage;
	}
	public IdNotValidException(String errorCode, String errprMessage) {
		super();
		this.errorCode = errorCode;
		this.errprMessage = errprMessage;
	}
	public IdNotValidException() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
