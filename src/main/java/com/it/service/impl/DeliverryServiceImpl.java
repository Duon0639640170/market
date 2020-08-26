package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dao.DeliverryRepository;
import com.it.dto.DeliverryDto;
import com.it.entity.DeliverryEntity;
import com.it.service.DeliverryService;


@Service
public class DeliverryServiceImpl implements DeliverryService {

	@Autowired(required=false)
	DeliverryRepository deliverryRepository;

	@Override
	public DeliverryDto saveDeliverry(DeliverryDto deliverryDto) throws Exception {
		if (deliverryDto !=null) {
			DeliverryEntity entity = convertDtoToEntit(deliverryDto);
			deliverryRepository.save(entity);
		}else {
			throw new NullPointerException("savepayment :: paymentDto is Null!");
		}
	
		return deliverryDto;
	}

	@Override
	public DeliverryDto updateDeliverry(DeliverryDto deliverryDto) throws Exception {
		if (deliverryDto !=null && deliverryDto.getDr_id() > 0) {
			DeliverryEntity entity = convertDtoToEntit(deliverryDto);
			deliverryRepository.save(entity);
		}else {
			throw new NullPointerException("updateDeliverry :: DeliverryDto is Null or Dr_id <0 !");
			
		}
		return deliverryDto;
	}

	@Override
	public Integer deleteDeliverryByDrId(Integer dr_id) throws Exception {
		if(dr_id > 0 ) {
			deliverryRepository.deleteById(dr_id);
		}else {
			throw new NullPointerException("deleteDeliverryByDrId :: dr_id <0");
		
		}
		return dr_id;
	}

	@Override
	public List<DeliverryDto>selectAllDeliverry() throws Exception {
		List<DeliverryDto> deliverryy = new ArrayList<>();
		List<DeliverryEntity> entities = (List<DeliverryEntity>) deliverryRepository.findAll();
		if (entities != null) {
			deliverryy = entities.stream()
					.map(entity -> convertEntityToDto(entity))
					.collect(Collectors.toList());
		}
		return deliverryy;
	}
	
	private DeliverryDto convertEntityToDto(DeliverryEntity entity) {
		DeliverryDto dto = new DeliverryDto();
		if (entity != null) {
			dto.setDr_id(entity.getDrId());
			dto.setOrder_id(entity.getOrderId());
			dto.setShop_id(entity.getShopId());
			dto.setDr_tracking_no(entity.getDrTrackingNo());
			dto.setDr_status(entity.getDrStatus());
			
		
		}
		return dto;		
	}
	
	private DeliverryEntity convertDtoToEntit(DeliverryDto dto) {
		DeliverryEntity entity = new DeliverryEntity();
		if (dto != null) {
			entity.setDrId(dto.getDr_id());
			entity.setOrderId(dto.getOrder_id());
			entity.setShopId(dto.getShop_id());
			entity.setDrTrackingNo(dto.getDr_tracking_no());
			entity.setDrStatus(dto.getDr_status());
			
		}
		return entity;		
	}

	@Override
	public DeliverryDto getDeliverryByDrId(Integer dr_id) throws Exception {
		DeliverryDto deliverryy = new DeliverryDto();
		if (dr_id > 0 ) {
			DeliverryEntity entity = deliverryRepository.findById(dr_id).get();
			if (entity != null) {
				deliverryy = convertEntityToDto(entity);
				
			}
		} else {
			throw new NullPointerException("getDeliverryByDrId :: dr_id < 0! ");
		}
		return deliverryy;
	}

	

}
