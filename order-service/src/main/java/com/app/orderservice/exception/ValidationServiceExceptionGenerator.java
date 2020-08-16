package com.app.orderservice.exception;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ValidationServiceExceptionGenerator {
	
	
	 public ValidationServiceException createValidationExceptionDetail(final String serviceErrorCode, final String path,
		      final String developerMessage) {
		    ValidationServiceException validationServiceException = new ValidationServiceException(serviceErrorCode);
		    validationServiceException.setPath(path);
		    validationServiceException.setDeveloperMessage(developerMessage);
		    return validationServiceException;
		  }
	 
	 
	 public ValidationServiceException
     createServiceExceptionWithChildError(final List<ValidationServiceException> validationServiceExceptionList) {
   ValidationServiceException validationServiceException =
       new ValidationServiceException(ErrorCodes.REQUEST_INVALID.name());
   for (ValidationServiceException childValidationServiceException : validationServiceExceptionList) {
     validationServiceException.addValidationException(childValidationServiceException);
   }
   return validationServiceException;
 }
}
