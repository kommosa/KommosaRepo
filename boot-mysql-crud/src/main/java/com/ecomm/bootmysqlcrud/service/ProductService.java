package com.ecomm.bootmysqlcrud.service;

import java.util.List;

import com.ecomm.bootmysqlcrud.dto.ProductDto;
import com.ecomm.bootmysqlcrud.exception.ProductNotFoundException;

public interface ProductService {
	
	ProductDto addProduct(ProductDto productDto);
	ProductDto getProductById(String productId) throws ProductNotFoundException;
	List<ProductDto> getProducts();
	void deleteProduct(String productId) throws ProductNotFoundException;
	ProductDto updateProduct(ProductDto productDto) throws ProductNotFoundException;

}
