package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.dao.PaymentRepository;
import com.it.dto.OrderDto;
import com.it.dto.PaymentDto;
import com.it.entity.OrderEntity;
import com.it.entity.PaymentEntity;
import com.it.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired(required = false)
	PaymentRepository paymentRepository;

	@Override
	public PaymentDto savePayment(PaymentDto paymentDto) throws Exception {
		if (paymentDto != null) {
			PaymentEntity entity = convertDtoToEntit(paymentDto);
			paymentRepository.save(entity);
		} else {
			throw new NullPointerException("savepayment :: paymentDto is Null!");
		}

		return paymentDto;
	}

	@Override
	public PaymentDto updatePayment(PaymentDto paymentDto) throws Exception {
		if (paymentDto != null && paymentDto.getPm_id() > 0) {
			PaymentEntity entity = convertDtoToEntit(paymentDto);
			paymentRepository.save(entity);
		} else {
			throw new NullPointerException("updatePayment :: PaymentDto is Null or PM_id <0 !");

		}
		return paymentDto;
	}

	@Override
	public Integer deletePaymentByPM_id(Integer pm_id) throws Exception {
		if (pm_id > 0) {
			paymentRepository.deleteById(pm_id);
		} else {
			throw new NullPointerException("deletePaymentByPM_id :: pm_id <0");

		}
		return pm_id;
	}

	@Override
	public List<PaymentDto> selectAllPayment() throws Exception {
		List<PaymentDto> paymentt = new ArrayList<>();
		List<PaymentEntity> entities = (List<PaymentEntity>) paymentRepository.findAll();
		if (entities != null) {
			paymentt = entities.stream().map(entity -> convertEntityToDto(entity)).collect(Collectors.toList());
		}
		return paymentt;
	}

	private PaymentDto convertEntityToDto(PaymentEntity entity) {
		PaymentDto dto = new PaymentDto();
		if (entity != null) {
			dto.setPm_id(entity.getPm_id());
			dto.setId(entity.getId());
			dto.setDr_adress(entity.getDr_adress());
			dto.setDr_status(entity.getDr_status());
			dto.setOrder_ref(entity.getOrder_ref());
			dto.setPm_totalpric(entity.getPm_totalpric());
			dto.setPm_img(entity.getPm_img());
			dto.setPm_date(entity.getPm_date());
			dto.setPm_status(entity.getPm_status());
			dto.setTracking_no(entity.getTracking_no());
			dto.setPm_no(entity.getPm_no());
			if (CollectionUtils.isNotEmpty(entity.getOrderEntities())) {
				dto.setOrders(convertOrderEntitiesToOrders(entity.getOrderEntities()));
			}

		}
		return dto;
	}

	private List<OrderDto> convertOrderEntitiesToOrders(List<OrderEntity> orderEntities){
		List<OrderDto> response = new ArrayList<>(); 
		if (CollectionUtils.isNotEmpty(orderEntities)) {
			for (OrderEntity entity: orderEntities) {
				response.add(new OrderDto(entity.getOrder_id(),
						entity.getId(),
						entity.getShop_id(),
						entity.getPd_id(),
						entity.getOrder_ref(),
						entity.getOrder_name(),
						entity.getOrder_date(),
						entity.getOrder_number()));
			}
		}
		return response;
	}

	private PaymentEntity convertDtoToEntit(PaymentDto dto) {
		PaymentEntity entity = new PaymentEntity();
		if (dto != null) {
			entity.setPm_id(dto.getPm_id());
			entity.setId(dto.getId());
			entity.setDr_adress(dto.getDr_adress());
			entity.setDr_status(dto.getDr_status());
			entity.setOrder_ref(dto.getOrder_ref());
			entity.setPm_totalpric(dto.getPm_totalpric());
			entity.setPm_img(dto.getPm_img());
			entity.setPm_date(dto.getPm_date());
			entity.setPm_status(dto.getPm_status());
			entity.setTracking_no(dto.getTracking_no());
			entity.setPm_no(dto.getPm_no());
		}
		return entity;
	}

	@Override
	public PaymentDto getPaymentByPM_id(Integer pm_id) throws Exception {
		PaymentDto payment = new PaymentDto();
		if (pm_id > 0) {
			PaymentEntity entity = paymentRepository.findById(pm_id).get();
			if (entity != null) {
				payment = convertEntityToDto(entity);

			}
		} else {
			throw new NullPointerException("getPaymentByPM_id :: pm_id < 0! ");
		}
		return payment;
	}

	@Override
	public List<PaymentDto> selectPaymentListById(int id) throws Exception {
		List<PaymentDto> payments = new ArrayList<>();
		List<PaymentEntity> entities = paymentRepository.findPaymentById(id);
		if (entities != null) {
			payments = entities.stream().map(entity -> convertEntityToDto(entity)).collect(Collectors.toList());
		}
		return payments;
	}

}
