package com.greenapex.SpringMapListProject.service;

import java.util.List;

import com.greenapex.SpringMapListProject.model.Product;

public interface IProductService {
	
public Product saveProduct(Product product);

public List<Product> getAllProduct();

public Product getProductById(Integer productId);

public void deleteProductById(Integer productId);

}
