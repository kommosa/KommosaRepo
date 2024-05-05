package com.ecomm.bootmysqlcrud.mapper;

public class ShopMapper {
	
	
	/*public static ShopDto mapToShopDto(Shops shops) {
		//return new ShopDto(shops.getShopperId(), shops.getProductid(), shops.getRelevancyScore());
		
		ShopDto shopDto=new ShopDto();
		List<ProductDtoForShop> productDtolist=new ArrayList<>();
		shops.getProductid().stream().forEach(prod->
		{
			ProductDtoForShop productDto=new ProductDtoForShop();
			productDto.setProductId(prod);
			//productDto.setRelevanceScore(prod);
		});
		shopDto.setShelf(productDtolist);
		shopDto.setShopperId(shops.getShopperId());
		
		return shopDto;
	}

	public static Shops mapToShops(ShopDto shopDto) {
		Shops shops=new Shops();
		shops.setShopperId(shopDto.getShopperId());
		shops.setProductid(shopDto.getShelf().stream().map(x->x.getProductId()).collect(Collectors.toList()));
		return shops;
	}*/

}
