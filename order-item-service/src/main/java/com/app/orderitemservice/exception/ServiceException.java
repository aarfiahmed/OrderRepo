package com.app.orderitemservice.exception;

public abstract class ServiceException  extends RuntimeException{
private String code;
private String developerMessage;
	
	public ServiceException(String code) {
		 super(code);
		 this.code=code;
	}

	
	public String getCode() {
		return code;
	}
	
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
}
