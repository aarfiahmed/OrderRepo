package com.app.orderservice.domainmodel;

import java.util.List;
import com.app.orderservice.domainmodel.OrderItem;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
	private String customerName;
	private String orderDate;
	private List<OrderItem> orderItems;
	private String total;
	private String shippingAddress;
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", orderDate=" + orderDate + ", orderItems=" + orderItems
				+ ", total=" + total + ", shippingAddress=" + shippingAddress + "]";
	}

	
}
