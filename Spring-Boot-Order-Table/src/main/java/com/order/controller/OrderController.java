package com.order.controller;

import com.order.entity.OrderEntity;
import com.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("api")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping("orderpage")
    public String orderPage()
    {
    	return "orderpage";
    }

    @PostMapping("saveorder")
    public String saveOrder(@ModelAttribute OrderEntity orderEntity) {
    	System.out.println("Hello Controller");
    	System.out.println(orderEntity.getName());
    	System.out.println(orderEntity.getPrice());
    	System.out.println(orderEntity.getQty());
    	orderService.saveOrder(orderEntity);
        return "orderpage";
    }

}