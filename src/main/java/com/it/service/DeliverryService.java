package com.it.service;

import java.util.List;

import com.it.dto.DeliverryDto;
import com.it.dto.PaymentDto;

public interface DeliverryService {

	public DeliverryDto saveDeliverry(DeliverryDto deliverryDto) throws Exception;

	public DeliverryDto updateDeliverry(DeliverryDto deliverryDto) throws Exception;

	public Integer deleteDeliverryByDrId(Integer dr_id) throws Exception;

	public List<DeliverryDto> selectAllDeliverry() throws Exception;
	
	public DeliverryDto getDeliverryByDrId (Integer dr_id) throws Exception;
	
}
