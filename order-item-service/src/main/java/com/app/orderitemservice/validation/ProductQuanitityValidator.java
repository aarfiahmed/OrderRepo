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
public class ProductQuanitityValidator {

	private ValidationServiceExceptionGenerator exceptionGenerator;

	@Autowired
	public ProductQuanitityValidator(ValidationServiceExceptionGenerator exceptionGenerator) {
		this.exceptionGenerator = exceptionGenerator;
	}

	public ValidationServiceException validate(String productQuantity) {

		if (StringUtils.isEmpty(productQuantity)) {
			return exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(),
					"productQuantity", "Invalid Product Quantity");
		}

		Pattern bookingIdentifierMatcher = Pattern.compile(OrderItemConstant.PRODUCT_QUANTITY_REGEX);
		if (!bookingIdentifierMatcher.matcher(productQuantity).matches()) {
			return exceptionGenerator.createValidationExceptionDetail(ErrorCodes.DATA_INVALID.name(),
					"quantity", "Invalid Product Quantity");
		}
		return null;
	}
}
