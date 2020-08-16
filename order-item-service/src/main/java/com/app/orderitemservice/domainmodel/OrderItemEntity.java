package com.app.orderitemservice.domainmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERITEM")
public class OrderItemEntity {

	@Id()
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
	 
	@Override
	public String toString() {
		return "OrderItemEntity [productId=" + productCode + ", productName=" + productName + ", quantity=" + quantity + "]";
	}
	
	
	


}
