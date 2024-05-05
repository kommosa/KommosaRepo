package com.ecomm.bootmysqlcrud.dto;

import java.math.BigDecimal;

public class ProductDtoForShop {
	
	
	
	private String productId;
	
	private BigDecimal relevanceScore;
	
	private String brand;
	

	private String category;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getRelevanceScore() {
		return relevanceScore;
	}

	public void setRelevanceScore(BigDecimal relevanceScore) {
		this.relevanceScore = relevanceScore;
	}
}
