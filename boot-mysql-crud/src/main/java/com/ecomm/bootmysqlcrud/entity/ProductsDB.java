package com.ecomm.bootmysqlcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TEST_PRODUCT_DB")
public class ProductsDB {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_products_generator")
  private long id;

    @Column(name = "PRODUCT_ID")
	private String productid;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "BRAND")
	private String brand;

	public ProductsDB(String productid, String category, String brand) {
		super();
		this.productid = productid;
		this.category = category;
		this.brand = brand;
	}

	public ProductsDB() {
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
