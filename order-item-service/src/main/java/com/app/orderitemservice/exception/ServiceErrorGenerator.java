package com.app.orderitemservice.exception;

import org.springframework.stereotype.Component;

import com.app.orderitemservice.error.ApplicationError;
import com.app.orderitemservice.error.ServiceErrors;
import com.app.orderitemservice.error.ValidationError;

@Component
public class ServiceErrorGenerator {
	
	
	public ServiceErrors generateError(ApplicationServiceException ex) {
		  ApplicationError applicationError = new ApplicationError(ex.getCode());
		  applicationError.setDeveloperMessage(ex.getMessage());
		return applicationError;
		
	}
	
	public ServiceErrors generateError(ValidationServiceException ex) {
		ValidationError validationErrors = new ValidationError(ErrorCodes.REQUEST_INVALID.name());
		ex.getValidationExceptions().forEach((exception)->
			validationErrors.addValidationError(createValidationError(exception)));
		return validationErrors;
		
	}
	
	
	
	private ValidationError createValidationError(final ValidationServiceException validationServiceException) {
		ValidationError validationError = new ValidationError(validationServiceException.getCode());
		    validationError.setPath(validationServiceException.getPath());
		    validationError.setDeveloperMessage(validationServiceException.getDeveloperMessage());
		    return validationError;
		  }

}
