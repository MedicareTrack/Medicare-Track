package com.app.DTO;

import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItemsDto {
     @PositiveOrZero
	 private int quantity;
     
	 private Long userId;
	 private Long productId;
}
