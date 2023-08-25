package com.app.customexception;

public class OutOfStockException extends RuntimeException {
   public OutOfStockException( String msg) {
	   super(msg);
   }

}
