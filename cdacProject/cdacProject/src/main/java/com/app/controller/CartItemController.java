package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CartItemsDto;
import com.app.repository.CartItemRepository;
import com.app.service.CartItemService;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
	@Autowired
	private CartItemService cartItemSer;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCartItemDetails(@Valid @RequestBody CartItemsDto cartItem){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartItemSer.addItemIntoCart(cartItem));
	}
	
	@GetMapping("/getCartItems/{id}")
	public ResponseEntity<?> getCartItemsById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartItemSer.getAllCartItemsForUser(id));
	}

}
