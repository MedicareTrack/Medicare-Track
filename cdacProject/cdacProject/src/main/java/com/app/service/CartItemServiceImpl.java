package com.app.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ApiResponse;
import com.app.DTO.CartItemsDto;
import com.app.customexception.CartItemEmptyException;
import com.app.customexception.OutOfStockException;
import com.app.customexception.ResourceNotFoundException;
import com.app.entities.CartItem;
import com.app.entities.Carts;
import com.app.entities.Products;
import com.app.repository.CartItemRepository;
import com.app.repository.CartsRepository;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {
	@Autowired
	private CartItemRepository cartItemRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CartsRepository cartRepo;
	@Autowired
	private UserRepository userRepo;
	

    // adding Items to the carts
	@Override
	public ApiResponse addItemIntoCart(CartItemsDto cartItem) {
		System.out.println("in item cart " + cartItem.getProductId());
		// find products for specific id
		Products product = productRepo.findById(cartItem.getProductId()).
				orElseThrow(() -> new ResourceNotFoundException("invalid Product Id"));
		// find cart for user assigned when he registered
		Carts cart = userRepo.findById(cartItem.getUserId()).
				orElseThrow(() -> new ResourceNotFoundException("invalid cart Id"))
				.getCart();
		
		//checking quantity for products available or not
		if(product.getStock()==0 || cartItem.getQuantity() > product.getStock())
			throw new OutOfStockException("stock not available now");
		double price = cartItem.getQuantity()*product.getPrice();
		CartItem sameItem=cartItemRepo.findByProductIdAndCartId(product, cart);
		
		// editing existing cart-Item 
		if(sameItem!=null) {
			sameItem.setQuantity(sameItem.getQuantity()+cartItem.getQuantity());
			sameItem.setTotalPrice(sameItem.getTotalPrice()+price);
			
			
			cart.setTotalPrice(cart.getTotalPrice()+price);
			cart.setTotalItem((cart.getTotalItem()+cartItem.getQuantity()));
		 return new ApiResponse("cart added successfully");
			
		 // creating new cart-Item
		}else {
			CartItem newCartItem=new CartItem(cartItem.getQuantity(),price,cart,product);
			cart.setTotalPrice(cart.getTotalPrice()+price);
			cart.setCartItem( newCartItem);
			cart.setTotalItem(cart.getTotalItem()+cartItem.getQuantity());
			cartItemRepo.save(newCartItem);
			return new ApiResponse("cart added successfully");
		}
		
	}


	@Override
	public Set<CartItem> getAllCartItemsForUser(Long userId) {
		
		Carts cart = userRepo.findById(userId).orElseThrow(()-> 
		new ResourceNotFoundException("id not exist")).getCart();
		
		Set<CartItem> cartItem = cart.getCartItem();
		if(cartItem.size() == 0)
			throw new CartItemEmptyException("Cart is empty");
		return cartItem;
	}




}
