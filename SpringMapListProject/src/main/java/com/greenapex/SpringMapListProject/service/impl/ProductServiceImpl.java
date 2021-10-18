package com.greenapex.SpringMapListProject.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greenapex.SpringMapListProject.model.Product;
import com.greenapex.SpringMapListProject.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	Map<Integer, Product> map=new HashMap<Integer, Product>();
	@Override
	public Product saveProduct(Product product) {
		map.put(product.getProductId(), product);
		return product;
	}
	@Override
	public List<Product> getAllProduct() {
		List<Product> productList=new ArrayList<Product>();
		map.forEach((id, product)->productList.add(product));
		return productList;
		
	}
	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		return map.get(productId);
		
	}
	@Override
	public void deleteProductById(Integer productId) {
		map.remove(productId);
		
	}
	

}
