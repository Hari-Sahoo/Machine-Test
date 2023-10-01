package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Product;
import com.example.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
//	@GetMapping("/products")
//	public void getproduct(@RequestBody Product product)
//	{
//		 productService.getproduct(product);	
//	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable int id,@RequestBody Product product)
	{
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id )
	{
		return productService.deleteProduct(id);
	}

}
