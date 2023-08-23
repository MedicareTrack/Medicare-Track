package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CategoryDto;
import com.app.service.CategoriesService;



@RestController
@RequestMapping("/Category")
public class CategoryController {
	@Autowired
	private CategoriesService categorySer;
	
	@PostMapping("/add")
	// adding new categories
	public ResponseEntity<?> addCategoryDetails(@RequestBody @Valid CategoryDto category){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(categorySer.addNewCategory(category));
	}
	
	//retrieving existing category
	@GetMapping("/{ID}")
	public ResponseEntity<?> getCategoryDetails(@PathVariable Long ID){
		return ResponseEntity.status(200).body(categorySer.getCategory(ID));
	}
	
	@DeleteMapping("/delete/{ID}")
	public ResponseEntity<?> deleteCategoryDetails(@PathVariable Long ID){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(categorySer.deleteCategory(ID));
	}
	
	
	

}
