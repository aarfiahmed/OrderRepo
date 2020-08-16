package com.app.orderservice.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.orderservice.domainmodel.Order;
import com.app.orderservice.domainmodel.OrderItem;
import com.app.orderservice.exception.ValidationServiceException;
import com.app.orderservice.exception.ValidationServiceExceptionGenerator;

@Component
public class RequestValidator {
	private static Logger logger = LoggerFactory.getLogger(RequestValidator.class);
	private ProductCodeValidator productCodeValidator;
	private ProductNameValidator productNameValidator;
	private ProductQuanitityValidator productQuanitityValidator;
	private OrderItemVallidator orderItemVallidator;
	private ValidationServiceExceptionGenerator exceptionGenerator;
	
	private CustomerNameValidator customerNameValidator;
	private OrderDateValidator orderDateValidator;
private AddressValidator addressValidator;
private OrderTotalValidator orderTotalValidator;
private OrderValidator orderValidator;
	



	public RequestValidator(ProductCodeValidator productCodeValidator, ProductNameValidator productNameValidator,
		ProductQuanitityValidator productQuanitityValidator, OrderItemVallidator orderItemVallidator,
		ValidationServiceExceptionGenerator exceptionGenerator, CustomerNameValidator customerNameValidator,
		OrderDateValidator orderDateValidator, AddressValidator addressValidator,
		OrderTotalValidator orderTotalValidator, OrderValidator orderValidator) {
	this.productCodeValidator = productCodeValidator;
	this.productNameValidator = productNameValidator;
	this.productQuanitityValidator = productQuanitityValidator;
	this.orderItemVallidator = orderItemVallidator;
	this.exceptionGenerator = exceptionGenerator;
	this.customerNameValidator = customerNameValidator;
	this.orderDateValidator = orderDateValidator;
	this.addressValidator = addressValidator;
	this.orderTotalValidator = orderTotalValidator;
	this.orderValidator=orderValidator;
}

	public void validate(String orderId) {
		List<ValidationServiceException> validationServiceExceptionlist = new ArrayList<ValidationServiceException>();
		validationServiceExceptionlist.add(orderValidator.validate(orderId));

		validationServiceExceptionlist.removeAll(Collections.singleton(null));
		if (!validationServiceExceptionlist.isEmpty()) {
			logger.error("Request validation exception occured. {}", validationServiceExceptionlist);
			throw exceptionGenerator.createServiceExceptionWithChildError(validationServiceExceptionlist);
		}
	}

	public void validate(Order order) {

		List<ValidationServiceException> validationServiceExceptionlist = new ArrayList<ValidationServiceException>();
		
		validationServiceExceptionlist.add(customerNameValidator.validate(order.getCustomerName()));
		validationServiceExceptionlist.add(orderDateValidator.validate(order.getOrderDate()));
		validationServiceExceptionlist.add(addressValidator.validate(order.getShippingAddress()));
		validationServiceExceptionlist.add(orderTotalValidator.validate(order.getTotal()));
		
		
	for(	OrderItem orderItem : order.getOrderItems()) {
				validationServiceExceptionlist.add(orderItemVallidator.validate(orderItem));
		if (orderItem != null) {
			validationServiceExceptionlist.add(productCodeValidator.validate(orderItem.getProductCode()));
			validationServiceExceptionlist.add(productNameValidator.validate(orderItem.getProductName()));
			validationServiceExceptionlist.add(productQuanitityValidator.validate(orderItem.getQuantity()));
		}
	}
		validationServiceExceptionlist.removeAll(Collections.singleton(null));
		if (!validationServiceExceptionlist.isEmpty()) {
			logger.error("Request validation exception occured. {}", validationServiceExceptionlist);
			throw exceptionGenerator.createServiceExceptionWithChildError(validationServiceExceptionlist);
		}
	}
}
