package com.ecomm.bootmysqlcrud.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TEST_SHOP_DB")
public class ShopsDB {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_shop_generator")
	private Long id;

//  @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "prod_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProductsDB productsDB;

	public Long getId() {
		return id;
	}

	@Column(name = "SHOPPER_ID")
	private String shopperId;
	
	
	@Column(name = "PRODUCT_ID")
	private String productId;
	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "relevancyScore")
	private BigDecimal relevancyScore;

	public String getShopperId() {
		return shopperId;
	}

	public BigDecimal getRelevancyScore() {
		return relevancyScore;
	}

	public void setRelevancyScore(BigDecimal relevancyScore) {
		this.relevancyScore = relevancyScore;
	}

	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}

	public ProductsDB getProductsData() {
		return productsDB;
	}

	public void setProductsData(ProductsDB productsDB) {
		this.productsDB = productsDB;
	}
	
	
}
