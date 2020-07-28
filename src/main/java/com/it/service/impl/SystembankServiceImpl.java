package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dao.OrderRepository;
import com.it.dao.SystembankRepository;
import com.it.dto.SystembankDto;
import com.it.entity.SystembankEntity;
import com.it.service.OrderService;
import com.it.service.SystembankService;

@Service
public class SystembankServiceImpl implements SystembankService{

	@Autowired(required=false)
	SystembankRepository systembankRepository;
	
	@Override
	public List<SystembankDto> selectAllSystembankDto() throws Exception {
		List<SystembankDto> orderr = new ArrayList<>();
		List<SystembankEntity> entities = (List<SystembankEntity>) systembankRepository.findAll();
		if (entities != null) {
			orderr = entities.stream()
					.map(entity -> convertEntityToDto(entity))
					.collect(Collectors.toList());
		}
		return orderr;
	}
	
	private SystembankDto convertEntityToDto(SystembankEntity entity) {
		SystembankDto dto = new SystembankDto();
		if (entity != null) {
			dto.setId(entity.getId());
			dto.setBank_account(entity.getBank_account());
			dto.setBank_name(entity.getBank_name());
			dto.setAccount_name(entity.getAccount_name());
		}
		return dto;		
	}
	
	private SystembankEntity convertDtoToEntit(SystembankDto dto) {
		SystembankEntity entity = new SystembankEntity();
		if (dto != null) {
			entity.setId(dto.getId());
			entity.setBank_account(dto.getBank_account());
			entity.setBank_name(dto.getBank_name());
			entity.setAccount_name(dto.getAccount_name());
					
		}
		return entity;		
	}

	@Override
	public SystembankDto getSystembankById(Integer id) throws Exception {
		SystembankDto system = new SystembankDto();
		if (id > 0 ) {
			SystembankEntity entity = systembankRepository.findById(id).get();
			if (entity != null) {
				system = convertEntityToDto(entity);
				
			}
		} else {
			throw new NullPointerException(" getSystembankById :: id < 0! ");
		}
		return system;
	}

}
