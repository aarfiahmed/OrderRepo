package com.app.orderitemservice.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.orderitemservice.domainmodel.OrderItem;
import com.app.orderitemservice.exception.ValidationServiceException;
import com.app.orderitemservice.exception.ValidationServiceExceptionGenerator;

@Component
public class RequestValidator {
	private static Logger logger = LoggerFactory.getLogger(RequestValidator.class);
	private OrderValidator orderValidator;
	private ProductNameValidator productNameValidator;
	private ProductQuanitityValidator productQuanitityValidator;
private OrderItemVallidator orderItemVallidator;
	private ValidationServiceExceptionGenerator exceptionGenerator;

	 

	@Autowired
	public RequestValidator(OrderValidator orderValidator, ProductNameValidator productNameValidator,
			ProductQuanitityValidator productQuanitityValidator,
			ValidationServiceExceptionGenerator exceptionGenerator,OrderItemVallidator orderItemVallidator) {
		this.orderValidator = orderValidator;
		this.productNameValidator = productNameValidator;
		this.productQuanitityValidator = productQuanitityValidator;
		this.exceptionGenerator = exceptionGenerator;
		this.orderItemVallidator=orderItemVallidator;
	}


	public void validate(String productCode) {
		List<ValidationServiceException> validationServiceExceptionlist = new ArrayList<ValidationServiceException>();
		validationServiceExceptionlist.add(orderValidator.validate(productCode));

		validationServiceExceptionlist.removeAll(Collections.singleton(null));
		if (!validationServiceExceptionlist.isEmpty()) {
			logger.error("Request validation exception occured. {}",validationServiceExceptionlist);
			throw exceptionGenerator.createServiceExceptionWithChildError(validationServiceExceptionlist);
		}
	}

	
	public void validate(OrderItem orderItem) {
		List<ValidationServiceException> validationServiceExceptionlist = new ArrayList<ValidationServiceException>();
		validationServiceExceptionlist.add(orderItemVallidator.validate(orderItem));
		if(orderItem!=null) {
		validationServiceExceptionlist.add(orderValidator.validate(orderItem.getProductCode()));
		validationServiceExceptionlist.add(productNameValidator.validate(orderItem.getProductName()));
		validationServiceExceptionlist.add(productQuanitityValidator.validate(orderItem.getQuantity()));
		}
		validationServiceExceptionlist.removeAll(Collections.singleton(null));
		if (!validationServiceExceptionlist.isEmpty()) {
			logger.error("Request validation exception occured. {}",validationServiceExceptionlist);
			throw exceptionGenerator.createServiceExceptionWithChildError(validationServiceExceptionlist);
		}
	}
}
