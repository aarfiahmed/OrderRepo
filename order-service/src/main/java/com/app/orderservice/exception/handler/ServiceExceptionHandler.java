package com.app.orderservice.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.orderservice.error.ServiceErrors;
import com.app.orderservice.exception.ApplicationServiceException;
import com.app.orderservice.exception.ErrorCodes;
import com.app.orderservice.exception.ServiceErrorGenerator;
import com.app.orderservice.exception.ValidationServiceException;

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
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex){
		Map<String, String>errors= new HashMap<String, String>();
		errors.put("errorCode", ErrorCodes.SYSTEM_UNAVAILABLE.name());
		errors.put("errorMessage", ex.getMessage());
		return new ResponseEntity<Map<String, String>>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
