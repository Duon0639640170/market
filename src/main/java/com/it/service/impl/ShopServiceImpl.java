package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.dao.ShopRepository;
import com.it.dto.ShopDto;
import com.it.entity.ShopEntity;
import com.it.service.ShopService;


@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired(required=false)
	ShopRepository shopRepository;

	@Override
	
	public ShopDto saveShop(ShopDto shopDto) throws Exception {
		if (shopDto !=null) {
			ShopEntity entity = convertDtoToEntit(shopDto);
			shopRepository.save(entity);
		}else {
			throw new NullPointerException("saveshop :: ShopDto is Null!");
		}
	
		return shopDto;
	}

	@Override
	public ShopDto updateShop(ShopDto shopDto) throws Exception {
		if (shopDto !=null && shopDto.getShop_id() > 0) {
			ShopEntity entity = convertDtoToEntit(shopDto);
			shopRepository.save(entity);
		}else {
			throw new NullPointerException("updateShop :: ShopDto is Null or Shop_id <0 !");
			
		}
		return shopDto;
	}

	@Override
	public Integer deleteShopByShop_id(Integer shop_id) throws Exception {
		if(shop_id > 0 ) {
			shopRepository.deleteById(shop_id);
		}else {
			throw new NullPointerException("deleteShopByShop_id :: shop_id <0");
		
		}
		return shop_id;
	}

	@Override
	public List<ShopDto> selectAllShop() throws Exception {
		List<ShopDto> shopp= new ArrayList<>();
		List<ShopEntity> entities = (List<ShopEntity>) shopRepository.findAll();
		if (entities != null) {
			shopp = entities.stream()
					.map(entity -> convertEntityToDto(entity))
					.collect(Collectors.toList());
		}
		return shopp;
	}
	
	private ShopDto convertEntityToDto(ShopEntity entity) {
		ShopDto dto = new ShopDto();
		if (entity != null) {
			dto.setShop_id(entity.getShop_id());
			dto.setId(entity.getId());
			dto.setShop_name(entity.getShop_name());
			dto.setShop_img(entity.getShop_img());
			dto.setShop_address(entity.getShop_address());
			dto.setShop_tel(entity.getShop_tel());
			
		}
		return dto;		
	}
	
	private ShopEntity convertDtoToEntit(ShopDto dto) {
		ShopEntity entity = new ShopEntity();
		if (dto != null) {
			entity.setShop_id(dto.getShop_id());
			entity.setId(dto.getId());
			entity.setShop_name(dto.getShop_name());
			entity.setShop_img(dto.getShop_img());
			entity.setShop_address(dto.getShop_address());
			entity.setShop_tel(dto.getShop_tel());
			
		}
		return entity;		
	}

	@Override
	public ShopDto getShopByShop_id(Integer shop_id) throws Exception {
		ShopDto shop = new ShopDto();
		if (shop_id> 0 ) {
			ShopEntity entity = shopRepository.findById(shop_id).get();
			if (entity != null) {
				shop = convertEntityToDto(entity);
				
			}
		} else {
			throw new NullPointerException("getShopByShop_id :: shop_id < 0! ");
		}
		return shop;
	}

	
	}

	




