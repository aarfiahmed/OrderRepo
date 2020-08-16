package com.app.orderservice.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ValidationServiceException extends ServiceException {

	private Collection<ValidationServiceException> validationExceptions;
	private String path;
	
	
	public ValidationServiceException(String msg) {
		super(msg);
	}
	
	
	public ValidationServiceException(final String code, final List<ValidationServiceException> childExceptions) {
		super(code);
		validationExceptions = childExceptions;
	}

	
	public Collection<ValidationServiceException> getValidationExceptions() {
		return validationExceptions;
	}
	
	
	public void addValidationException(final ValidationServiceException validationException) {
		if (validationExceptions == null) {
			validationExceptions = new ArrayList();
		}
		validationExceptions.add(validationException);
	}

	public String getPath() {
		return path;
	}

	public void setPath(final String path) {
		this.path = path;
	}
}
