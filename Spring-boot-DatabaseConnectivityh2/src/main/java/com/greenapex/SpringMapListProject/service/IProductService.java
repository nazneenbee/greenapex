package com.greenapex.SpringMapListProject.service;

import java.util.List;
import java.util.Optional;

import com.greenapex.SpringMapListProject.entity.ProductEntity;
import com.greenapex.SpringMapListProject.model.Product;

public interface IProductService {
	
public ProductEntity saveProduct(Product product);

public List<ProductEntity> getAllProduct();

public Optional<ProductEntity> getProductById(Integer productId);

public void deleteProductById(Integer productId);

}
