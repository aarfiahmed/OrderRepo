package com.app.orderitemservice.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.orderitemservice.domainmodel.OrderItem;
import com.app.orderitemservice.service.OrderItemService;
import com.app.orderitemservice.validation.RequestValidator;

@RestController
public class OrderItemController {
private static Logger logger=LoggerFactory.getLogger(OrderItemController.class);
	private OrderItemService orderItemService;
	private RequestValidator  requestValidator; 
	
	
@Autowired	
	public OrderItemController(OrderItemService orderItemService,RequestValidator  requestValidator) {
		this.orderItemService = orderItemService;
		this.requestValidator=requestValidator;
	}




	@GetMapping("order-items/{orderId}")
	public ResponseEntity<List<OrderItem>> getOrderItemDetails(@PathVariable String orderId){
		logger.info("getting order item details for {}",orderId);
		requestValidator.validate(orderId);
		return new ResponseEntity<List<OrderItem>> (orderItemService.getOrderItem(orderId),HttpStatus.OK);
	}
	
	@PostMapping("order-items")
	public ResponseEntity<Void> createOrderItemDetails(@RequestBody OrderItem orderItem){
		logger.info("creating order item details  {}",orderItem);
		requestValidator.validate(orderItem);
		orderItemService.createOrderItem(orderItem);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
