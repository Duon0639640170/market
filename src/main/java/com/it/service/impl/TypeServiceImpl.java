package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dao.TypeRepository;
import com.it.dto.TypeDto;
import com.it.entity.TypeEntity;
import com.it.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired(required=false)
	TypeRepository typeRepository;
	
	@Override
	public TypeDto getTypeByTypeId(Integer type_id) throws Exception {
		TypeDto type = new TypeDto();
		if (type_id > 0 ) {
			TypeEntity entity = typeRepository.findById(type_id).get();
			if (entity != null) {
			type = convertEntityToDto(entity);
				
			}
		} else {
			throw new NullPointerException("getTypeByType_id :: type_id < 0! ");
		}
		return type;
	}

	@Override
	public List<TypeDto> selectAllType() throws Exception {
		List<TypeDto> type= new ArrayList<>();
		List<TypeEntity> entities = (List<TypeEntity>) typeRepository.findAll();
		if (entities != null) {
			type = entities.stream()
					.map(entity -> convertEntityToDto(entity))
					.collect(Collectors.toList());
		}
		return type;
	}
	
	private TypeDto convertEntityToDto(TypeEntity entity) {
		TypeDto dto = new TypeDto();
		if (entity != null) {
			dto.setType_id(entity.getType_id());
			dto.setType_name(entity.getType_name());
			dto.setType_detail(entity.getType_detail());
			dto.setType_status(entity.getType_status());
			
		}
		return dto;		
	}
	
	private TypeEntity convertDtoToEntit(TypeDto dto) {
		TypeEntity entity = new TypeEntity();
		if (dto != null) {
			entity.setType_id(dto.getType_id());
			entity.setType_name(dto.getType_name());
			entity.setType_detail(dto.getType_detail());
			entity.setType_status(dto.getType_status());
			
		}
		return entity;		
	}
	
	
}
