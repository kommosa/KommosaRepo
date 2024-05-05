package com.ecomm.bootmysqlcrud.dto;

import java.math.BigDecimal;
import java.util.List;

public class ShopDto {
	
	
	private String shopperId;
	
	private List<ProductDtoForShop> shelf;
	
	

	/*
	 * public ShopDto(String shopperId, List<String> productid, BigDecimal
	 * relevancyScore) { // TODO Auto-generated constructor stub
	 * 
	 * }
	 */
	public String getShopperId() {
		return shopperId;
	}

	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}

	public List<ProductDtoForShop> getShelf() {
		return shelf;
	}

	public void setShelf(List<ProductDtoForShop> shelf) {
		this.shelf = shelf;
	}

}