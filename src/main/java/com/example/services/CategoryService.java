package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.models.Category;
import com.example.models.Product;
import com.example.reporitories.CategoryRepository;
import com.example.responseWrapper.ResponseWrapper;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public ResponseEntity <?> GetCategory(int id )
	{
		boolean isCategory = categoryRepository.existsById(id);
		if(isCategory)
		{
			List<Category> getcategory = categoryRepository.findAll();
			ResponseWrapper  rwr = new ResponseWrapper();
			rwr.setMessage("List of Category.");
			rwr.setData(getcategory);
			return new ResponseEntity<>(rwr, HttpStatus .FOUND);
		}else
		{
			throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Category id does not exist.");
		}
	}
	
	public ResponseEntity<?> UpdateCategory(int id , Category category)
	{
		Optional<Category> isCategory = categoryRepository.findById(id);
		if (isCategory.isPresent()) {
			Category existCategory = isCategory.get();
			existCategory.setCategoryName(category.getCategoryName());
			Category update = categoryRepository.save(existCategory);
			ResponseWrapper  rwr = new ResponseWrapper();
			rwr.setMessage("Data updated.");
			rwr.setData(update);
			return new ResponseEntity<>(rwr, HttpStatus .OK);
		}else
		{
			throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Category id does not exist.");

		}
	}
	
	public ResponseEntity<?> deleteCategory(int id)
	{
		boolean isCategory = categoryRepository.existsById(id);
		if (isCategory) {
			categoryRepository.deleteById(id);
			ResponseWrapper  rwr = new ResponseWrapper();
			rwr.setMessage("Deleted successfully.");
			return new ResponseEntity<>(rwr, HttpStatus .OK);
		}else
		{
			throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Category id does not exist.");

		}
	}
}
