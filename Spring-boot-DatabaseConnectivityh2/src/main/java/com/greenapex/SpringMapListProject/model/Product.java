package com.greenapex.SpringMapListProject.model;

public class Product {
	private Integer productId;
	private String productName;
	private String description;
	public Integer getProductId() {
		return productId;
	} 
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}