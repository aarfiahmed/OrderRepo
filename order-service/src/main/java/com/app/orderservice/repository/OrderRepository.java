package com.app.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {

}
