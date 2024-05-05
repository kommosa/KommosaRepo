package com.ecomm.bootmysqlcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecomm.bootmysqlcrud.entity.ProductsDB;
import com.ecomm.bootmysqlcrud.exception.ProductNotFoundException;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductsDB, Long> {
	

	ProductsDB findByProductid(String productid);
	List<ProductsDB> findAll();
	
	
	 @Transactional
	 void deleteByProductid(String productid);
	 
	 
	 @Query("SELECT el FROM ProductsDB el WHERE  el.productid IN :prodList  and (:brand is null or el.brand = :brand) and (:category is null or el.category = :category)   ORDER BY el.productid ASC  limit :limit")
	 List<ProductsDB> findTotalProductList(List<String> prodList,String brand,String category,int limit) throws ProductNotFoundException;
	 
	 
	 
	 List<ProductsDB> findAllBybrand(@Param("brand") String brand) throws ProductNotFoundException;
	
	 List<ProductsDB> findAllBycategory(@Param("category") String category) throws ProductNotFoundException;

}
