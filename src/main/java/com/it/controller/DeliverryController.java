package com.it.controller;

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

import com.it.dto.DeliverryDto;
import com.it.service.DeliverryService;


@RestController
public class DeliverryController {
	
	@Autowired(required = false)
	DeliverryService deliverryservice;

	@PostMapping("/deliverry/save")
	public ResponseEntity<DeliverryDto> saveDeliverry(@RequestBody DeliverryDto deliverryDto) throws Exception {
		deliverryservice.saveDeliverry(deliverryDto);
		return new ResponseEntity<DeliverryDto>(deliverryDto, HttpStatus.OK);
	}

	@PostMapping("/deliverry/update")
	public ResponseEntity<DeliverryDto> updateDeliverry(@RequestBody DeliverryDto deliverryDto) throws Exception {
		deliverryservice.updateDeliverry(deliverryDto);
		return new ResponseEntity<DeliverryDto>(deliverryDto, HttpStatus.OK);
	}

	@DeleteMapping("/deliverry/{dr_id}")
	public ResponseEntity<Integer> deleteDeliverryByDrId(@PathVariable Integer dr_id) throws Exception {
		deliverryservice.deleteDeliverryByDrId(dr_id);
		return new ResponseEntity<Integer>(dr_id, HttpStatus.OK);
	}

	@GetMapping("/deliverry/{dr_id}")
	public ResponseEntity<DeliverryDto> getDeliverryByDrId(@PathVariable Integer dr_id) throws Exception {
		DeliverryDto deliverryDto = deliverryservice.getDeliverryByDrId(dr_id);
		return new ResponseEntity<DeliverryDto>(deliverryDto, HttpStatus.OK);
	}

	@GetMapping("/deliverry")
	public ResponseEntity<List<DeliverryDto>> selectAllDeliverry() throws Exception {
		List<DeliverryDto> response = deliverryservice.selectAllDeliverry();
		return new ResponseEntity<List<DeliverryDto>>(response, HttpStatus.OK);
	}
}
