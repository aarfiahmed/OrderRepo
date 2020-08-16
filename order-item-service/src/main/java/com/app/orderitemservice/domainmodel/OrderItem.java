package com.app.orderitemservice.domainmodel;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {
	private String orderId;
	private String productCode;
	private String productName;
	private String quantity;

public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public OrderItem() {
	 
	}
	public OrderItem(String productId, String productName, String quantity) {
		this.productCode = productId;
		this.productName = productName;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductItem [productId=" + productCode + ", productName=" + productName + ", quantity=" + quantity + "]";
	}
	
	
	

}
