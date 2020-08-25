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
import com.it.dto.ShopDto;
import com.it.dto.TypeDto;
import com.it.service.TypeService;

@RestController
public class TypeController {

	@Autowired(required = false)
	TypeService typeService;

	@GetMapping("/type/{type_id}")
	public ResponseEntity<TypeDto> getTypeByTypeId(@PathVariable Integer type_id) throws Exception {
		TypeDto typeDto = typeService.getTypeByTypeId(type_id);
		return new ResponseEntity<TypeDto>(typeDto, HttpStatus.OK);
	}
	
	@GetMapping("/type")
	public ResponseEntity<List<TypeDto>> selectAllType() throws Exception{
		List<TypeDto> response = typeService.selectAllType();
		return new ResponseEntity<List<TypeDto>>(response, HttpStatus.OK);
	}
	
	

}
