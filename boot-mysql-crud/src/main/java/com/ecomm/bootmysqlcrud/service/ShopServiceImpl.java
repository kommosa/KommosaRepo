package com.ecomm.bootmysqlcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.bootmysqlcrud.dto.ProductDto;
import com.ecomm.bootmysqlcrud.dto.ShopDto;
import com.ecomm.bootmysqlcrud.dto.ShopRequest;
import com.ecomm.bootmysqlcrud.entity.ProductsDB;
import com.ecomm.bootmysqlcrud.entity.ShopsDB;
import com.ecomm.bootmysqlcrud.exception.ProductNotFoundException;
import com.ecomm.bootmysqlcrud.repository.ProductRepository;
import com.ecomm.bootmysqlcrud.repository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService{

	
	@Autowired
	ShopRepository shoprepository;
	
	
	@Autowired
	ProductRepository prodrepository;
	
	
	@Override
	public ShopDto addProducttoShop(ShopDto shopDto) {
		//Shops shops = ShopMapper.mapToShops(shopDto);
		shopDto.getShelf().stream().forEach(shop->
		{
			ShopsDB shops=new ShopsDB();
			shops.setShopperId(shopDto.getShopperId());
			ProductsDB productsDB=new ProductsDB();
			productsDB.setProductid(shop.getProductId());
			productsDB.setBrand(shop.getBrand());
			productsDB.setCategory(shop.getCategory());
			ProductsDB savedProducts=prodrepository.save(productsDB);
			shops.setProductsData(savedProducts);
			shops.setRelevancyScore(shop.getRelevanceScore());
			shops.setProductId(shop.getProductId());
			ShopsDB createdShops =shoprepository.save(shops);
		});
		return shopDto;
	}


	@Override
	public List<ProductsDB> getProductsByShopperId(ShopRequest productDto) throws ProductNotFoundException {
		List<String> prodIds=shoprepository.findProductDBbyShopperId(productDto.getShopperId());
		List<ProductsDB> prodDb=prodrepository.findTotalProductList(prodIds,productDto.getBrand(),productDto.getCategory(),productDto.getLimit());
		return prodDb;
	}


	@Override
	public List<ProductDto> getProductsByCategory(String Category) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
