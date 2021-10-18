package com.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "ordertable")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
    @Column(name="name")
    @NotBlank(message="name should not black")
    private String name;
    
    @Column(name="qty")
    private int qty;

   @Column(name="price")
   private int price;
   
}