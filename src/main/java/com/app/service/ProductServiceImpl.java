package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ApiResponse;
import com.app.DTO.ProductDto;
import com.app.entities.Categories;
import com.app.entities.Products;
import com.app.exc_handler.ResourceNotFoundException;
import com.app.repository.CategoryRepository;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
    private	ProductRepository productRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CategoryRepository categoryRepo;

	// adding new product details
	@Override
	public ApiResponse addProductDetails(ProductDto productDetails) {
		//System.out.println(productDetails);
		Long id = productDetails.getCategoryId();
		Categories category = categoryRepo.findById(id) .orElseThrow(()-> new ResourceNotFoundException("Category ID not Exist"));
		Products product = mapper.map(productDetails, Products.class);
		product.setCategoryId(category);
		//System.out.println(product);
		productRepo.save(product);
		return new ApiResponse("Product Details Added Successful");
	}

	@Override
	public ApiResponse deleteProductDetails(Long id) {
		Products product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID not exist"));
		productRepo.delete(product);
		return new ApiResponse("Product deleted Successfullu");
	}

	@Override
	public ApiResponse updateProductDetals(ProductDto products) {
		return null;
	}
	

}
