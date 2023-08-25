package com.app.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Carts;
import com.app.entities.User;
import com.app.repository.CartsRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	private CartsRepository cartsRepo;

	@Override
	public Carts addCartForUser(User user) {
		Carts cart = new Carts();
		System.out.println("in carts");
		cart.setCreatedDate(LocalDate.now());
		cart.setUpdatedDate(LocalDate.now());
		cart.setUser(user);
		return cartsRepo.save(cart);
	}

}
