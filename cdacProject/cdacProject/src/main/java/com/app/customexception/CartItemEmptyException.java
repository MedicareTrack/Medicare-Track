package com.app.customexception;

public class CartItemEmptyException extends RuntimeException {
	public CartItemEmptyException(String msg) {
		super(msg);

}
}
