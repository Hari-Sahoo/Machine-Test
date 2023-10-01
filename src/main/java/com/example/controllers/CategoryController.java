package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Category;
import com.example.models.Product;
import com.example.services.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories/{id}")
	public ResponseEntity <?> GetCategory(@PathVariable int id )
	{
		return categoryService.GetCategory(id);
	}

	@PutMapping("/categories/{id}")
	public ResponseEntity<?> UpdateCategory(@PathVariable int id ,@RequestBody Category category)
	{
		return categoryService.UpdateCategory(id, category);
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id)
	{
		return categoryService.deleteCategory(id);
	}



}
