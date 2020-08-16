package com.app.orderitemservice.validation;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.orderitemservice.OrderItemConstant;
import com.app.orderitemservice.exception.ErrorCodes;
import com.app.orderitemservice.exception.ValidationServiceException;
import com.app.orderitemservice.exception.ValidationServiceExceptionGenerator;

@Component
public class OrderValidator {

	private ValidationServiceExceptionGenerator exceptionGenerator;

	@Autowired
	public OrderValidator(ValidationServiceExceptionGenerator exceptionGenerator) {
		this.exceptionGenerator = exceptionGenerator;
	}

	public ValidationServiceException validate(String orderDate) {

		if (StringUtils.isEmpty(orderDate)) {
			return exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(),
					"orderId", "Invalid Order Id");
		}

		Pattern bookingIdentifierMatcher = Pattern.compile(OrderItemConstant.ORDER_ID_REGEX);
		if (!bookingIdentifierMatcher.matcher(orderDate).matches()) {
			return exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(),
					"orderId", "Invalid Order Id");
		}
		return null;
	}


}
