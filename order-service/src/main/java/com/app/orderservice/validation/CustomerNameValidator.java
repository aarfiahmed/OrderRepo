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
public class CustomerNameValidator {



	private ValidationServiceExceptionGenerator exceptionGenerator;

	@Autowired
	public CustomerNameValidator(ValidationServiceExceptionGenerator exceptionGenerator) {
		this.exceptionGenerator = exceptionGenerator;
	}

	public ValidationServiceException validate(String customerName) {

		if (StringUtils.isEmpty(customerName)) {
			return exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(),
					"customerName", "Invalid Customer Name");
		}

		Pattern bookingIdentifierMatcher = Pattern.compile(OrderConstant.CUSTOMER_NAME_REGEX);
		if (!bookingIdentifierMatcher.matcher(customerName).matches()) {
			return exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(),
					"customerName", "Invalid Customer Name");
		}
		return null;
	}

}
