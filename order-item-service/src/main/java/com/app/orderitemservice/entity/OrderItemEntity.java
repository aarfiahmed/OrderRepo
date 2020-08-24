package com.app.orderitemservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERITEM")
public class OrderItemEntity {

	@Id()
	@Column(name = "order_id")
	private String orderId;
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "quantity")
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
