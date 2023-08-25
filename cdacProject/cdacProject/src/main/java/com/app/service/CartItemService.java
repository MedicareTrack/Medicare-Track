package com.app.service;

import java.util.Set;

import com.app.DTO.ApiResponse;
import com.app.DTO.CartItemsDto;
import com.app.entities.CartItem;

public interface CartItemService {

	ApiResponse addItemIntoCart(CartItemsDto cartitem);
	
	Set<CartItem> getAllCartItemsForUser(Long userId);
}
