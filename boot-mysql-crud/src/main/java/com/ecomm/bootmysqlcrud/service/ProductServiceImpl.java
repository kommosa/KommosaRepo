package com.ecomm.bootmysqlcrud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.bootmysqlcrud.dto.ProductDto;
import com.ecomm.bootmysqlcrud.entity.ProductsDB;
import com.ecomm.bootmysqlcrud.exception.ProductNotFoundException;
import com.ecomm.bootmysqlcrud.mapper.ProductMapper;
import com.ecomm.bootmysqlcrud.repository.ProductRepository;


@Service 
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		ProductsDB product = ProductMapper.mapToProduct(productDto);
		ProductsDB createdEmployee = productRepository.save(product);
		return ProductMapper.mapToProductDto(createdEmployee);
	}

	@Override
	public ProductDto getProductById(String productId) throws ProductNotFoundException {
		ProductsDB products = productRepository.findByProductid(productId);
		if (products ==null) {
			throw new ProductNotFoundException("Product with id - " + productId + " not found.");
		}
		return ProductMapper.mapToProductDto(products);
	}

	@Override
	public List<ProductDto> getProducts() {
		List<ProductsDB> products = productRepository.findAll();
		return products.stream().map((prod) -> ProductMapper.mapToProductDto(prod)).collect(Collectors.toList());
	}

	@Override
	public void deleteProduct(String productId) throws ProductNotFoundException {
		/*
		 * ProductsDB products = productRepository.findByProductid(productId); if
		 * (products==null) { throw new ProductNotFoundException("Product with id - " +
		 * productId + " not found."); }
		 */
		productRepository.deleteByProductid(productId);
		
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) throws ProductNotFoundException {
		ProductsDB retrievedProducts = productRepository.findByProductid(productDto.getProductId());
		if (retrievedProducts==null) {
			throw new ProductNotFoundException("Product with id - " + productDto.getProductId() + " not found.");
		}
		ProductsDB product = retrievedProducts;
		//employee.setName(employeeDto.getName());
		//employee.setDepartment(employeeDto.getDepartment());
		product.setProductid(productDto.getProductId());
		product.setBrand(productDto.getBrand());
		product.setCategory(productDto.getCategory());
		ProductsDB createdproduct = productRepository.save(product);
		return ProductMapper.mapToProductDto(createdproduct);
	}

	

}
