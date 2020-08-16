package com.app.orderservice.constant;

public class OrderConstant {
	public static final String PRODUCT_QUANTITY_REGEX = "[0-9]{1,20}";
	public static final String CUSTOMER_NAME_REGEX = "[a-zA-Z]{1,30}";
	public static final String ORDER_TOTAL_REGEX = "[0-9]{1,20}";
	public static final String ORDER_DATE_REGEX = null;
	public static final String ORDER_ID_REGEX = "[a-zA-Z0-9-]{1,70}";
}
