package com.app.orderitemservice.error;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ServiceErrors {
	private String code;
	private String developerMessage;
	
	public String getCode() {
		return code;
	}


	public ServiceErrors(String code) {
		super();
		this.code = code;
	}
	 
	
	public String getDeveloperMessage() {
		return developerMessage;
	}
	
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
