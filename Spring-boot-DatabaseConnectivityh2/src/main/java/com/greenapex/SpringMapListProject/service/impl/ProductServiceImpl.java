package com.greenapex.SpringMapListProject.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greenapex.SpringMapListProject.entity.ProductEntity;
import com.greenapex.SpringMapListProject.model.Product;
import com.greenapex.SpringMapListProject.repository.ProductRepository;
import com.greenapex.SpringMapListProject.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductEntity saveProduct(Product product) {
		ProductEntity productEntity=new ProductEntity();
		
		productEntity.setName(product.getProductName());
		productEntity.setDescription(product.getDescription());
	    ProductEntity pr= productRepository.save(productEntity);
		return pr;
	}
	@Override
	public List<ProductEntity> getAllProduct() {
		
		List<ProductEntity> productList=productRepository.findAll();
		return productList;
		
	}
	//@Override
	public Optional<ProductEntity> getProductById(Integer productId) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> data= productRepository.findById(productId);
		if(data.isPresent())
		{
			return data;
		}
		else
		{
			return Optional.of(new ProductEntity());
		}
	}
	@Override
	public void deleteProductById(Integer productId) {
		productRepository.deleteById(productId);
		
	}
	

}
