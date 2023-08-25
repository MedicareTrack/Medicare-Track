package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CartItem;
import com.app.entities.Carts;
import com.app.entities.Products;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	CartItem findByProductIdAndCartId(Products product, Carts cart);
}
