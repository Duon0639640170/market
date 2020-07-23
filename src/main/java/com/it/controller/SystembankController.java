package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.it.dto.SystembankDto;
import com.it.entity.SystembankEntity;
import com.it.service.SystembankService;

@RestController
public class SystembankController {

	
@Autowired(required=false)
	
	SystembankService systembankService;
	
	
		@GetMapping("/bank/{id}")
	public ResponseEntity<SystembankDto> getSystem_bankById (@PathVariable Integer id) throws Exception{
		SystembankDto systembankDto = systembankService.getSystembankById(id);
		return new ResponseEntity<SystembankDto>(systembankDto, HttpStatus.OK);		
	}

	@GetMapping("/bank")
	public ResponseEntity<List<SystembankDto>> getAllOrder() throws Exception{
		List<SystembankDto> response = systembankService.selectAllSystembankDto();
		return new ResponseEntity<List<SystembankDto>>(response, HttpStatus.OK);
	}
		
}
