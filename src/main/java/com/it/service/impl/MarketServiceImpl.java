package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.dao.MarketRepository;
import com.it.dto.MarketDto;
import com.it.entity.MarketEntity;
import com.it.service.MarketService;


@Service
public class MarketServiceImpl implements MarketService{
	
	@Autowired(required=false)
	MarketRepository marketRepository;

	
	@Override
	
	public MarketDto saveMarket(MarketDto marketDto) throws Exception {
		if (marketDto !=null) {
			MarketEntity entity = convertDtoToEntit(marketDto);
			marketRepository.save(entity);
		}else {
			throw new NullPointerException("savemarket :: MarketDao is Null!");
		}
	
		return marketDto;
	}

	@Override
	public MarketDto updateMarket(MarketDto marketDto) throws Exception {
		if (marketDto !=null && marketDto.getUser_id() > 0) {
			MarketEntity entity = convertDtoToEntit(marketDto);
			marketRepository.save(entity);
		}else {
			throw new NullPointerException("updateMarket :: MarketDto is Null or USer_id <0 !");
			
		}
		return marketDto;
	}

	@Override
	public Integer deleteMarketByUser_id(Integer user_id) throws Exception {
		if(user_id > 0 ) {
			marketRepository.deleteById(user_id);
		}else {
			throw new NullPointerException("deleteMarketByUser_id :: user_id <0");
		
		}
		return user_id;
	}

	@Override
	public List<MarketDto> selectAllMarket() throws Exception {
		List<MarketDto> markett= new ArrayList<>();
		List<MarketEntity> entities = (List<MarketEntity>) marketRepository.findAll();
		if (entities != null) {
			markett = entities.stream()
					.map(entity -> convertEntityToDto(entity))
					.collect(Collectors.toList());
		}
		return markett;
	}
	
	private MarketDto convertEntityToDto(MarketEntity entity) {
		MarketDto dto = new MarketDto();
		if (entity != null) {
			dto.setUser_id(entity.getUser_id());
			dto.setUsername(entity.getUsername());
			dto.setPassword(entity.getPassword());
			dto.setUser_name(entity.getUser_name());
			dto.setUser_lastname(entity.getUser_lastname());
			dto.setUser_address(entity.getUser_address());
			dto.setUser_tel(entity.getUser_tel());
			dto.setUser_sex(entity.getUser_sex());
			dto.setUser_status(entity.getUser_status());	
		}
		return dto;		
	}
	
	private MarketEntity convertDtoToEntit(MarketDto dto) {
		MarketEntity entity = new MarketEntity();
		if (dto != null) {
			entity.setUser_id(dto.getUser_id());
			entity.setUsername(dto.getUsername());
			entity.setPassword(dto.getPassword());
			entity.setUser_name(dto.getUser_name());
			entity.setUser_lastname(dto.getUser_lastname());
			entity.setUser_address(dto.getUser_address());
			entity.setUser_tel(dto.getUser_tel());
			entity.setUser_sex(dto.getUser_sex());
			entity.setUser_status(dto.getUser_status());	
		}
		return entity;		
	}

	@Override
	public MarketDto getMarketByUser_id(Integer user_id) throws Exception {
		MarketDto market = new MarketDto();
		if (user_id> 0 ) {
			MarketEntity entity = marketRepository.findById(user_id).get();
			if (entity != null) {
				market = convertEntityToDto(entity);
				
			}
		} else {
			throw new NullPointerException("getMarketByUser_id :: user_id < 0! ");
		}
		return market;
	}

	
	}

	




