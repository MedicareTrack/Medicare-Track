package com.app.service;

import com.app.DTO.ApiResponse;
import com.app.DTO.ProductDto;

public interface ProductService {
	ApiResponse addProductDetails(ProductDto productDetails);
	
	ApiResponse deleteProductDetails(Long id);
	
	ApiResponse updateProductDetals(ProductDto products);

}
