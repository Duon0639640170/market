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
import com.it.dto.MarketDto;
import com.it.service.MarketService;;

@RestController
public class MarketController {
	

	
	@Autowired(required=false)
	
	MarketService marketservice;

	@GetMapping("/ping")
	public ResponseEntity<String> ping(){
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@PostMapping("/market/save")
	public ResponseEntity<MarketDto> saveStudent(@RequestBody MarketDto marketDto) throws Exception{		
		marketservice.saveMarket(marketDto);
		return new ResponseEntity<MarketDto>(marketDto, HttpStatus.OK);
	}
	
	@PostMapping("/market/update")
	public ResponseEntity<MarketDto> updateMarket(@RequestBody MarketDto marketDto) throws Exception{
		marketservice.updateMarket(marketDto);
		return new ResponseEntity<MarketDto>(marketDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/market/{user_id}")
	public ResponseEntity<Integer> deleteMarketByUser_id(@PathVariable Integer user_id) throws Exception{
		marketservice.deleteMarketByUser_id(user_id);
		return new ResponseEntity<Integer>(user_id, HttpStatus.OK);		
	}
		@GetMapping("/market/{user_id}")
	public ResponseEntity<MarketDto> getMarketByUser_id (@PathVariable Integer user_id) throws Exception{
		MarketDto marketDto = marketservice.getMarketByUser_id(user_id);
		return new ResponseEntity<MarketDto>(marketDto, HttpStatus.OK);		
	}
	
	
	@GetMapping("/market")
	public ResponseEntity<List<MarketDto>> getAllMarket() throws Exception{
		List<MarketDto> response = marketservice.selectAllMarket();
		return new ResponseEntity<List<MarketDto>>(response, HttpStatus.OK);
	}
	
	
}
