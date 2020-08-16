package com.app.orderitemservice.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.orderitemservice.exception.ErrorCodes;
import com.app.orderitemservice.exception.ValidationServiceException;
import com.app.orderitemservice.exception.ValidationServiceExceptionGenerator;

@Component
public class ProductNameValidator {

private ValidationServiceExceptionGenerator exceptionGenerator;


	@Autowired
	public ProductNameValidator(ValidationServiceExceptionGenerator exceptionGenerator) {
	this.exceptionGenerator = exceptionGenerator;
}



	public ValidationServiceException validate(String productName) {
		ValidationServiceException exception=null;
		
		if(productName==null || productName.trim().equals("")) {
			exception=	exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(), "productName", "Invalid Product Name");
		} 
		return exception;
	}

}
