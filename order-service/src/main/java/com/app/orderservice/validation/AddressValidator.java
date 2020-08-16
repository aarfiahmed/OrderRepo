package com.app.orderservice.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.orderservice.exception.ErrorCodes;
import com.app.orderservice.exception.ValidationServiceException;
import com.app.orderservice.exception.ValidationServiceExceptionGenerator;

@Component
public class AddressValidator {


private ValidationServiceExceptionGenerator exceptionGenerator;


	@Autowired
	public AddressValidator(ValidationServiceExceptionGenerator exceptionGenerator) {
	this.exceptionGenerator = exceptionGenerator;
}



	public ValidationServiceException validate(String shippingAddress) {
		ValidationServiceException exception=null;
		
		if(shippingAddress==null || shippingAddress.trim().equals("")) {
			exception=	exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(), "shippingAddress", "Invalid shippingAddress");
		} 
		return exception;
	}


}
