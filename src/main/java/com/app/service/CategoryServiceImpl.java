package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ApiResponse;
import com.app.DTO.CategoriesResponseDto;
import com.app.DTO.CategoryDto;
import com.app.entities.Categories;
import com.app.exc_handler.ResourceNotFoundException;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoriesService{

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ModelMapper mapper;
	@Override
	public ApiResponse addNewCategory(CategoryDto category) {
		Categories categoryDetails = mapper.map(category, Categories.class);
		categoryRepo.save(categoryDetails);
		return new ApiResponse("Category Added successfully");
	}
	@Override
	public CategoriesResponseDto getCategory(Long Id) {
		Categories category = categoryRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Id not exist"));
	    CategoriesResponseDto categoryDet = mapper.map(category, CategoriesResponseDto.class);
	    return categoryDet;
	}
	
	@Override
	public List<CategoriesResponseDto> getAllCategories() {
       List<Categories> list = categoryRepo.findAll();
		
		List<CategoriesResponseDto> categoryList = new ArrayList<>();
		for(Categories cat : list) {
			categoryList.add(mapper.map(cat, CategoriesResponseDto.class));
		}
         return categoryList;
	}
	
	@Override
	public ApiResponse deleteCategory(Long categoryId) {
		Categories category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Id not exist"));
		
	    categoryRepo.delete(category);
	    return new ApiResponse("catgories deleted successfully");
	}

}
