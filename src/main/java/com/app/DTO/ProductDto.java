package com.app.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;



import com.app.entities.Categories;

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
public class ProductDto {
	
	@NotBlank(message = "name can't be blank ")
	private String name;
	
	private double price;
	
	@NotBlank(message = "description can't be blank ")
	private String description;
	
	private int stock;
	
	private long categoryId;
	
	@NotBlank(message = "name can't be blank ")
    private String imagePath;
	@Future
	private LocalDate expDate;

}
