package com.ecomm.bootmysqlcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecomm.bootmysqlcrud.entity.ProductsDB;
import com.ecomm.bootmysqlcrud.entity.ShopsDB;
import com.ecomm.bootmysqlcrud.exception.ProductNotFoundException;

public interface ShopRepository extends JpaRepository<ShopsDB, Long> {
	
	
	
	//@Query("Select a from ProductsDB a  left join ShopsDB b on a.productid=b.productId and b.shopperId= :shopperId")
	@Query("Select b.productId from  ShopsDB b where b.shopperId= :shopperId")
	List<String> findProductDBbyShopperId(@Param("shopperId") String shopperId) throws ProductNotFoundException;
	
	

}

