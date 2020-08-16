package com.app.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.orderservice.domainmodel.Order;
import com.app.orderservice.domainmodel.OrderItem;
import com.app.orderservice.entity.OrderEntity;
import com.app.orderservice.exception.ApplicationServiceException;
import com.app.orderservice.exception.ErrorCodes;
import com.app.orderservice.repository.OrderItemRepository;
import com.app.orderservice.repository.OrderRepository;

import feign.FeignException;

@Service
public class OrderService {
private static final Logger logger= LoggerFactory.getLogger(OrderService.class);
	private OrderRepository orderRepository;
private OrderItemRepository orderItemRepository;
	@Autowired
	public OrderService(OrderRepository orderRepository,OrderItemRepository orderItemRepository) {
		this.orderRepository = orderRepository;
		this.orderItemRepository=orderItemRepository;
	}

	public Order getOrderDetails(String orderId) {
		List<OrderItem> orderItems=null;
		OrderEntity orders= orderRepository.findById(orderId).orElseThrow(()->new ApplicationServiceException("Order Not Found"));
		Order orderDetails = getOrderDetails(orders);
		try {
			 orderItems = orderItemRepository.getOrderItem(orderId);
			logger.info("got the response from order item service {}",orderItems);
			}catch(FeignException ex) {
				ApplicationServiceException exception = new ApplicationServiceException(ErrorCodes.SYSTEM_UNAVAILABLE.name());
				exception.setDeveloperMessage(ex.getMessage());
				throw exception;
			}
		orderDetails.setOrderItems(orderItems);;
		return orderDetails;
	}

	public String createOrderDetails(Order order) {
		String orderId = UUID.randomUUID().toString();
		OrderEntity orderEntity = getOrderEntity(order);
		orderEntity.setOrderId(orderId);
		
		orderRepository.save(orderEntity);
		orderRepository.flush();
		
		try {
			order.getOrderItems().stream().forEach(items->{
				items.setOrderId(orderId);
				orderItemRepository.createOrderItemDetails(items);
			});
		}catch(FeignException ex) {
			orderRepository.deleteById(orderId);
			ApplicationServiceException exception = new ApplicationServiceException(ErrorCodes.SYSTEM_UNAVAILABLE.name());
			exception.setDeveloperMessage(ex.getMessage());
			throw exception;
		}

		return orderId;
	}

	private OrderEntity getOrderEntity(Order order) {
		OrderEntity entity = new OrderEntity();
		entity.setOrderDate(order.getOrderDate());
		entity.setCustomerName(order.getCustomerName());
		entity.setShippingAddress(order.getShippingAddress());
		entity.setTotal(order.getTotal());
		return entity;
	}
	
	private Order getOrderDetails(OrderEntity entity) {
		Order order= new Order();
		order.setCustomerName(entity.getCustomerName());
		order.setOrderDate(entity.getOrderDate());
		order.setShippingAddress(entity.getShippingAddress());
		order.setTotal(entity.getTotal());
		return order;
	}
}
