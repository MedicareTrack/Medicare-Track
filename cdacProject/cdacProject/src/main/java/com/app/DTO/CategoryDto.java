package com.app.DTO;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	@NotBlank(message = "Category Name should not be blank")
	private String categoryName;
	@NotBlank(message = "Category description should not be blank")
	private String description;

}
