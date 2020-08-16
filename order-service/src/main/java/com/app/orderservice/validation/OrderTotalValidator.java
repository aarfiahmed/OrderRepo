package com.app.orderservice.validation;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.orderservice.constant.OrderConstant;
import com.app.orderservice.exception.ErrorCodes;
import com.app.orderservice.exception.ValidationServiceException;
import com.app.orderservice.exception.ValidationServiceExceptionGenerator;

@Component
public class OrderTotalValidator {




	private ValidationServiceExceptionGenerator exceptionGenerator;

	@Autowired
	public OrderTotalValidator(ValidationServiceExceptionGenerator exceptionGenerator) {
		this.exceptionGenerator = exceptionGenerator;
	}

	public ValidationServiceException validate(String orderTotal) {

		if (StringUtils.isEmpty(orderTotal)) {
			return exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(),
					"total", "Invalid total");
		}

		Pattern bookingIdentifierMatcher = Pattern.compile(OrderConstant.ORDER_TOTAL_REGEX);
		if (!bookingIdentifierMatcher.matcher(orderTotal).matches()) {
			return exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(),
					"total", "Invalid total");
		}
		return null;
	}
}
