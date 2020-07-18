package com.it.service;

import java.util.List;
import com.it.dto.ShopDto;

public interface ShopService {

	public ShopDto saveShop(ShopDto shopDto) throws Exception;

	public ShopDto updateShop(ShopDto shopDto) throws Exception;

	public Integer deleteShopByShop_id(Integer shop_id) throws Exception;

	public List<ShopDto> selectAllShop() throws Exception;
	
	public ShopDto getShopByShop_id (Integer shop_id) throws Exception;
	
}
