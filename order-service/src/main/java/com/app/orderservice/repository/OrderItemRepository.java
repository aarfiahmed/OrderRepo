package com.app.orderservice.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.orderservice.domainmodel.OrderItem;

@FeignClient(name = "OrderItemServiceV1")
public interface OrderItemRepository {
	
	@GetMapping("order-items/{orderId}")
	public List<OrderItem> getOrderItem(@PathVariable("orderId")String orderId );
	
	@PostMapping("order-items")
	public void createOrderItemDetails( OrderItem orderItem);

}
