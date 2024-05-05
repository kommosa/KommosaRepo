package com.ecomm.bootmysqlcrud.mapper;

import com.ecomm.bootmysqlcrud.dto.ProductDto;
import com.ecomm.bootmysqlcrud.entity.ProductsDB;

public class ProductMapper {
	
	
	public static ProductDto mapToProductDto(ProductsDB product) {
		return new ProductDto(product.getProductid(), product.getCategory(), product.getBrand());
	}

	public static ProductsDB mapToProduct(ProductDto productDto) {
		return new ProductsDB(productDto.getProductId(), productDto.getCategory(), productDto.getBrand());
	}


}
