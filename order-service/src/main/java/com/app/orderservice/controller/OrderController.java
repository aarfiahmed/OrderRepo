package com.app.orderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.orderservice.domainmodel.Order;
import com.app.orderservice.service.OrderService;
import com.app.orderservice.validation.RequestValidator;

@Controller
public class OrderController {

	
	private static final Logger logger= LoggerFactory.getLogger(OrderController.class);
	
	private RequestValidator requestValidator;
	private OrderService orderService;
	
	
	
	@Autowired
	public OrderController(RequestValidator requestValidator,OrderService orderService) {
		this.requestValidator = requestValidator;
		this.orderService=orderService;
	}




	@GetMapping("orders/{orderId}")
	public ResponseEntity<Order> getOrderDetails(@PathVariable String orderId){
		logger.info("getting order details for order id {}",orderId);
		requestValidator.validate(orderId);
		orderService.getOrderDetails(orderId);
		return new ResponseEntity<Order>(orderService.getOrderDetails(orderId), HttpStatus.OK);
	}
	
	@PostMapping("orders")
	public ResponseEntity<String> createOrder(@RequestBody Order order){
		logger.info("creating order {}",order);
//		requestValidator.validate(order);
		String orderId = orderService.createOrderDetails(order);
		return new ResponseEntity<String>(orderId,HttpStatus.CREATED);
	}
}
