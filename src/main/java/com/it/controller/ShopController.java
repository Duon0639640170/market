package com.it.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.it.dto.ShopDto;
import com.it.service.ShopService;;

@RestController
public class ShopController {
	

	
	@Autowired(required=false)
	
	ShopService shopservice;

	
	
	@PostMapping("/shop/save")
	public ResponseEntity<ShopDto> saveShop(@RequestBody ShopDto shopDto) throws Exception{		
		shopservice.saveShop(shopDto);
		return new ResponseEntity<ShopDto>(shopDto, HttpStatus.OK);
	}
	
	@PostMapping("/shop/update")
	public ResponseEntity<ShopDto> updateMarket(@RequestBody ShopDto shopDto) throws Exception{
		shopservice.updateShop(shopDto);
		return new ResponseEntity<ShopDto>(shopDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/shop/{shop_id}")
	public ResponseEntity<Integer> deleteShopByShop_id(@PathVariable Integer shop_id) throws Exception{
		shopservice.deleteShopByShop_id(shop_id);
		return new ResponseEntity<Integer>(shop_id, HttpStatus.OK);		
	}
		@GetMapping("/shop/{shop_id}")
	public ResponseEntity<ShopDto> getShopByShop (@PathVariable Integer shop_id) throws Exception{
			ShopDto shopDto = shopservice.getShopByShop_id(shop_id);
		return new ResponseEntity<ShopDto>(shopDto, HttpStatus.OK);		
	}
	
	
	@GetMapping("/shop")
	public ResponseEntity<List<ShopDto>> getAllShop() throws Exception{
		List<ShopDto> response = shopservice.selectAllShop();
		return new ResponseEntity<List<ShopDto>>(response, HttpStatus.OK);
	}
	
	
}
