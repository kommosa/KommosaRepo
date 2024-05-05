package com.ecomm.bootmysqlcrud.service;

import java.util.List;

import com.ecomm.bootmysqlcrud.dto.ProductDto;
import com.ecomm.bootmysqlcrud.dto.ShopDto;
import com.ecomm.bootmysqlcrud.dto.ShopRequest;
import com.ecomm.bootmysqlcrud.entity.ProductsDB;
import com.ecomm.bootmysqlcrud.exception.ProductNotFoundException;

public interface ShopService {

	ShopDto addProducttoShop(ShopDto shopDto);
	
	
	List<ProductsDB> getProductsByShopperId(ShopRequest productDto) throws ProductNotFoundException;
	
	//List<>
	List<ProductDto> getProductsByCategory(String Category)throws ProductNotFoundException;
	
}
