package com.app.orderservice.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.orderservice.exception.ErrorCodes;
import com.app.orderservice.exception.ValidationServiceException;
import com.app.orderservice.exception.ValidationServiceExceptionGenerator;

@Component
public class ProductCodeValidator {
private ValidationServiceExceptionGenerator exceptionGenerator;


	@Autowired
	public ProductCodeValidator(ValidationServiceExceptionGenerator exceptionGenerator) {
	this.exceptionGenerator = exceptionGenerator;
}



	public ValidationServiceException validate(String productCode) {
		ValidationServiceException exception=null;
		
		if(productCode==null || productCode.trim().equals("")) {
			exception=	exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(), "productcode", "Invalid Product Code");
		} 
		return exception;
	}
}
