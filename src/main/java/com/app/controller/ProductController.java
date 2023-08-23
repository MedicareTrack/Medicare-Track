package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.ProductDto;
import com.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productSer;
	
	// adding new product details
	@PostMapping("/add")
	public ResponseEntity<?> addProductDetails(@RequestBody @Valid ProductDto product){
		return  ResponseEntity.status(HttpStatus.OK).body(productSer.addProductDetails(product));
	}
	
	// delete an existing product details
	@DeleteMapping("/delete/{ID}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable Long ID ){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productSer.deleteProductDetails(ID));
	}
	
	//updating existing product details
//	@PatchMapping("/update")
	

}
