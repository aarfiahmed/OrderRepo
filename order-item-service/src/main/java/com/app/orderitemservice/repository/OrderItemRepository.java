package com.app.orderitemservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.orderitemservice.entity.OrderItemEntity;

public interface OrderItemRepository  extends JpaRepository<OrderItemEntity, String>{
	
	

}
