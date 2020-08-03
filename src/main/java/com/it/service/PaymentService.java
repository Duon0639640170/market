package com.it.service;

import java.util.List;

import com.it.dto.PaymentDto;


public interface PaymentService {

	public PaymentDto savePayment(PaymentDto paymentDto) throws Exception;

	public PaymentDto updatePayment(PaymentDto paymentDto) throws Exception;

	public Integer deletePaymentByPM_id(Integer pm_id) throws Exception;

	public List<PaymentDto> selectAllPayment() throws Exception;
	
	public List<PaymentDto> selectPaymentListById(int id) throws Exception;
	
	public PaymentDto getPaymentByPM_id (Integer pm_id) throws Exception;
	
}
