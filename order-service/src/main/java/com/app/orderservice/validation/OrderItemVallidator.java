package com.app.orderservice.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.orderservice.domainmodel.OrderItem;
import com.app.orderservice.exception.ErrorCodes;
import com.app.orderservice.exception.ValidationServiceException;
import com.app.orderservice.exception.ValidationServiceExceptionGenerator;

@Component
public class OrderItemVallidator {

	

private ValidationServiceExceptionGenerator exceptionGenerator;


	@Autowired
	public OrderItemVallidator(ValidationServiceExceptionGenerator exceptionGenerator) {
	this.exceptionGenerator = exceptionGenerator;
}



	public ValidationServiceException validate(OrderItem orderItem) {
		ValidationServiceException exception=null;
		
		if(orderItem==null ) {
			exception=	exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(), "json request", "all required fields are missing");
		} 
		return exception;
	}

}
