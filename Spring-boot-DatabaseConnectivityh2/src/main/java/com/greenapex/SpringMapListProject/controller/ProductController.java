package com.greenapex.SpringMapListProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.SpringMapListProject.entity.ProductEntity;
import com.greenapex.SpringMapListProject.model.Product;
import com.greenapex.SpringMapListProject.service.IProductService;

@RestController

// save the data
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@PostMapping("product")
	public ProductEntity saveProduct(@RequestBody Product product)
	{
		System.out.println("Saving Product"+product.getProductId());
		return productService.saveProduct(product);
	}
	
	@GetMapping("products")
	public List<ProductEntity> getAllProduct()
	{
		System.out.println("getting Product");
		return productService.getAllProduct();
	}
	@GetMapping("singleproduct")
	public Optional<ProductEntity> getProductById(@RequestParam("productId") Integer productId)
	{
		System.out.println("get Product By Id");
		return productService.getProductById(productId);
	}
	
	@PostMapping("multipleproduct")
	public List<Product> saveProducts(@RequestBody List<Product> productList)
	{
		System.out.println("Saving Products");
		productList.forEach((product)->productService.saveProduct(product));
		return productList;
	}
	
	@DeleteMapping("deleteproduct")
	public void deleteProducts(@RequestParam("productId") Integer productId)
	{
		System.out.println("Delete Products");
		productService.deleteProductById(productId);
	}
}
