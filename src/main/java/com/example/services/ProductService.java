package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.models.Product;
import com.example.reporitories.ProductRepository;
import com.example.responseWrapper.ResponseWrapper;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	

	
	public ResponseEntity<?> getProductById(int id)
	{
		boolean isIdExist = productRepository.existsById(id);
		if (isIdExist) 
		{
			 Optional<Product> getProduct = productRepository.findById(id);
			 ResponseWrapper rwr = new ResponseWrapper();
			 rwr.setMessage("Data founded.");
			 rwr.setData(getProduct);
			 return new ResponseEntity<>(rwr, HttpStatus.FOUND);
		}else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id does not exist.");
		}
	}
	
	public ResponseEntity<?> updateProduct(int id, Product product)
	{
		Optional<Product> isIdExist = productRepository.findById(id);
		if (isIdExist.isPresent()) 
		{
			Product existProduct = isIdExist.get();
			existProduct.setName(product.getName());
			existProduct.setPrice(product.getPrice());
			existProduct.setCategory(product.getCategory());
			Product updated = productRepository.save(existProduct);
			 ResponseWrapper rwr = new ResponseWrapper();
			 rwr.setMessage("Data updated.");
			 rwr.setData(updated);
			 return new ResponseEntity<>(rwr, HttpStatus.OK);
		}else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id does not exist.");

		}
		
	}
	
	public ResponseEntity<?> deleteProduct(int id)
	{
		boolean isIdExist = productRepository.existsById(id);
		if (isIdExist) 
		{
			productRepository.deleteById(id);
			 ResponseWrapper rwr = new ResponseWrapper();
			 rwr.setMessage("Deleted successfully.");
			 return new ResponseEntity<>(rwr, HttpStatus.OK);
		}else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id does not exist.");

		}
	}
	
}
