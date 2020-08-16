package com.app.orderitemservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.orderitemservice.domainmodel.OrderItem;
import com.app.orderitemservice.domainmodel.OrderItemEntity;
import com.app.orderitemservice.exception.ApplicationServiceException;
import com.app.orderitemservice.repository.OrderItemRepository;

@Service
public class OrderItemService {

	
	private OrderItemRepository  orderItemRepository; 
	
	
	@Autowired
	public OrderItemService(OrderItemRepository orderItemRepository) {
		this.orderItemRepository = orderItemRepository;
	}



	public List<OrderItem> getOrderItem(String orderId) {
	List<String>ids= new ArrayList<String>();
	ids.add(orderId);
		List<OrderItemEntity> orderItemEntity = orderItemRepository. findAllById(ids);
		 List<OrderItem> orderItems = orderItemEntity.stream().filter(i->i!=null).map(item->new OrderItem(item.getProductCode(), item.getProductName(), item.getQuantity())).collect(Collectors.toList());
if(orderItems==null || orderItems.isEmpty()) {
		throw new ApplicationServiceException("OrderItemNotFound");
}
	return 	orderItems;
	}



	public void createOrderItem(OrderItem orderItem) {
		orderItemRepository.save(getOrderItemEntity(orderItem));
		orderItemRepository.flush();
	}
	
	private OrderItemEntity getOrderItemEntity(OrderItem orderItem) {
		OrderItemEntity entity= new OrderItemEntity();
		entity.setProductCode(orderItem.getProductCode());
		entity.setProductName(orderItem.getProductName());
		entity.setQuantity(orderItem.getQuantity());
		entity.setOrderId(orderItem.getOrderId());
		return entity;
	}
	
}
