package com.app.service;

import com.app.entities.Carts;
import com.app.entities.User;

public interface CartService {
	
	Carts addCartForUser(User user);

}
