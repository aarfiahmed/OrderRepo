package com.app.orderitemservice.exception.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.orderitemservice.error.ServiceErrors;
import com.app.orderitemservice.exception.ApplicationServiceException;
import com.app.orderitemservice.exception.ServiceErrorGenerator;
import com.app.orderitemservice.exception.ValidationServiceException;

@ControllerAdvice
public class ServiceExceptionHandler {
	
	private ServiceErrorGenerator serviceErrorGenerator;
	
	
@Autowired
	public ServiceExceptionHandler(ServiceErrorGenerator serviceErrorGenerator) {
		this.serviceErrorGenerator = serviceErrorGenerator;
	}



	@ExceptionHandler(ApplicationServiceException.class)
	public ResponseEntity<ServiceErrors> handleApplicationServiceException(ApplicationServiceException ex){
		ServiceErrors exception = serviceErrorGenerator.generateError(ex);
		return new ResponseEntity<ServiceErrors>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ValidationServiceException.class)
	public ResponseEntity<ServiceErrors> handleValidationServiceException(ValidationServiceException ex){
		ServiceErrors exception = serviceErrorGenerator.generateError(ex);
		return new ResponseEntity<ServiceErrors>(exception, HttpStatus.BAD_REQUEST);
	}
	
}
