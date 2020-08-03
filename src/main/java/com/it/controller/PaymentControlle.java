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
import com.it.dto.PaymentDto;
import com.it.service.PaymentService;

@RestController
public class PaymentControlle {

	@Autowired(required = false)

	PaymentService paymentservice;

	@PostMapping("/payment/save")
	public ResponseEntity<PaymentDto> savePayment(@RequestBody PaymentDto paymentDto) throws Exception {
		paymentservice.savePayment(paymentDto);
		return new ResponseEntity<PaymentDto>(paymentDto, HttpStatus.OK);
	}

	@PostMapping("/payment/update")
	public ResponseEntity<PaymentDto> updatePayment(@RequestBody PaymentDto paymentDto) throws Exception {
		paymentservice.updatePayment(paymentDto);
		return new ResponseEntity<PaymentDto>(paymentDto, HttpStatus.OK);
	}

	@DeleteMapping("/payment/{pm_id}")
	public ResponseEntity<Integer> deletePaymentByPM_id(@PathVariable Integer pm_id) throws Exception {
		paymentservice.deletePaymentByPM_id(pm_id);
		return new ResponseEntity<Integer>(pm_id, HttpStatus.OK);
	}

	@GetMapping("/payment/{pm_id}")
	public ResponseEntity<PaymentDto> getPaymentByShop(@PathVariable Integer pm_id) throws Exception {
		PaymentDto paymentDto = paymentservice.getPaymentByPM_id(pm_id);
		return new ResponseEntity<PaymentDto>(paymentDto, HttpStatus.OK);
	}

	@GetMapping("/payment")
	public ResponseEntity<List<PaymentDto>> getAllPayment() throws Exception {
		List<PaymentDto> response = paymentservice.selectAllPayment();
		return new ResponseEntity<List<PaymentDto>>(response, HttpStatus.OK);
	}

	@GetMapping("/payment-by-id/{id}")
	public ResponseEntity<List<PaymentDto>> getPaymentListById(@PathVariable Integer id) throws Exception {
		List<PaymentDto> response = paymentservice.selectPaymentListById(id);
		return new ResponseEntity<List<PaymentDto>>(response, HttpStatus.OK);
	}
}
