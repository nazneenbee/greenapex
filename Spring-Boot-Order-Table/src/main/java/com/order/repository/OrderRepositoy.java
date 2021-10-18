package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderEntity;

@Repository
public interface OrderRepositoy extends JpaRepository<OrderEntity, Integer> {
	
	
}
