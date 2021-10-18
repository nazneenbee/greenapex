package com.order.service.imple;


import com.order.entity.OrderEntity;
import com.order.repository.OrderRepositoy;
import com.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

   @Autowired
  OrderRepositoy orderRepositoy;

@Override
public OrderEntity saveOrder(OrderEntity order) {
	// TODO Auto-generated method stub
	return orderRepositoy.save(order);
}

   
}