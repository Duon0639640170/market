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

import com.it.dto.ProductDto;
import com.it.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired(required=false)
	ProductService productService;

	
	
	@PostMapping("/product/save")
	public ResponseEntity<ProductDto> saveStudent(@RequestBody ProductDto productDto) throws Exception{		
		productService.saveProduct(productDto);
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
	}
	
	@PostMapping("/product/update")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) throws Exception{
		productService.updateProduct(productDto);
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{sId}")
	public ResponseEntity<Integer> deleteProductByPD_id(@PathVariable Integer pd_id) throws Exception{
		productService.deleteProductByPD_id(pd_id);
		return new ResponseEntity<Integer>(pd_id, HttpStatus.OK);		
	}
	
	@GetMapping("/product/{pd_id}")
	public ResponseEntity<ProductDto> getProductByPD_id (@PathVariable Integer pd_id) throws Exception{
		ProductDto productDto = productService.getProductByPD_id(pd_id);
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);		
	}
	
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductDto>> getAllProduct() throws Exception{
		List<ProductDto> response = productService.selectAllProduct();
		return new ResponseEntity<List<ProductDto>>(response, HttpStatus.OK);
	}
	
	
}
