package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.DTO.ApiResponse;
import com.app.DTO.CategoriesResponseDto;
import com.app.DTO.CategoryDto;

public interface CategoriesService {
	ApiResponse addNewCategory(CategoryDto category);
	
	CategoriesResponseDto getCategory(Long Id);

	List<CategoriesResponseDto> getAllCategories();

	ApiResponse deleteCategory(Long categoryId);

}
