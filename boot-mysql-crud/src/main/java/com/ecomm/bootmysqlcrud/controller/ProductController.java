package com.ecomm.bootmysqlcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.bootmysqlcrud.dto.ProductDto;
import com.ecomm.bootmysqlcrud.dto.ShopDto;
import com.ecomm.bootmysqlcrud.dto.ShopRequest;
import com.ecomm.bootmysqlcrud.entity.ProductsDB;
import com.ecomm.bootmysqlcrud.exception.ProductNotFoundException;
import com.ecomm.bootmysqlcrud.service.ProductService;
import com.ecomm.bootmysqlcrud.service.ShopService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@Autowired
	ShopService shopService;
	
	//To Create Products
	@PostMapping(value = "/addProduct")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
		ProductDto addedProduct = productService.addProduct(productDto);
		return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
	}	
	
	//This endpoint is to store Products in that particular shopId
	@PostMapping(value = "/addProductsToShop")
	public ResponseEntity<ShopDto> addProductToShop(@RequestBody ShopDto shopDto) {
		ShopDto addedProduct = shopService.addProducttoShop(shopDto);
		return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
	}	
	
	//This endpoint to retrieve the ProductList based on the SearchCriteria ShopperID is Mandatory Parameter
	@GetMapping(value = "/shopper/getProductsList")
	public ResponseEntity<List<ProductsDB>> getProductsByShopperId(@RequestBody ShopRequest productDto)
			throws ProductNotFoundException {
		try {
			List<ProductsDB> product = shopService.getProductsByShopperId(productDto);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (ProductNotFoundException productNotFoundException) {
			throw productNotFoundException;
		}
	}
	
	
	
	
	
	@GetMapping(value = "/product/{productId}")
	public ResponseEntity<ProductDto> getEmployeeById(@PathVariable("productId") String productId)
			throws ProductNotFoundException {
		try {
			ProductDto product = productService.getProductById(productId);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (ProductNotFoundException productNotFoundException) {
			throw productNotFoundException;
		}
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> getEmployees() {
		List<ProductDto> products = productService.getProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/removeProduct/{productId}")
	public ResponseEntity<HttpStatus> deleteEmployees(@PathVariable("productId") String productId)
			throws ProductNotFoundException {
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/updateproduct")
	public ResponseEntity<ProductDto> updateEmployee(@RequestBody ProductDto productDto)
			throws ProductNotFoundException {
		ProductDto createdEmployee = productService.updateProduct(productDto);
		return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
	}

	
	
	
}
