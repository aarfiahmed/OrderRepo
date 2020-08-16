package com.app.orderitemservice.error;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationError extends ServiceErrors {
	private String path;
	List<ValidationError> childErrors;
	
	
	
	
	
	public ValidationError(String code) {
		super(code);
	}

	public List<ValidationError> getChildErrors() {
		return childErrors;
	}
	public void addValidationError(final ValidationError childValidationError) {
	    if (childErrors == null) {
	      childErrors = new ArrayList<ValidationError>();
	    }
	    childErrors.add(childValidationError);
	  }
	
	public String getPath() {
		return path;
	}
	 
	public void setPath(String path) {
		this.path = path;
	}

}
