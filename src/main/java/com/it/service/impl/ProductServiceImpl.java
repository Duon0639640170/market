package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dao.ProductRepository;
import com.it.dto.ProductDto;
import com.it.dto.ShopDto;
import com.it.entity.ProductEntity;
import com.it.entity.ShopEntity;
import com.it.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired(required=false)
	ProductRepository productRepository;

	@Override
	public ProductDto saveProduct(ProductDto productDto) throws Exception {
		if (productDto !=null) {
			ProductEntity entity = convertDtoToEntit(productDto);
			productRepository.save(entity);
		}else {
			throw new NullPointerException("saveproduct :: ProductDto is Null!");
		}
	
		return productDto;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) throws Exception {
		if (productDto !=null && productDto.getPd_id() > 0) {
			ProductEntity entity = convertDtoToEntit(productDto);
			productRepository.save(entity);
		}else {
			throw new NullPointerException("updatePorduct :: ProductDto is Null or PD_id <0 !");
			
		}
		return productDto;
	}

	@Override
	public Integer deleteProductByPD_id(Integer pd_id) throws Exception {
		if(pd_id > 0 ) {
			productRepository.deleteById(pd_id);
		}else {
			throw new NullPointerException("deleteProductByPD_id :: pd_id <0");
		
		}
		return pd_id;
	}

	@Override
	public List<ProductDto> selectAllProduct() throws Exception {
		List<ProductDto> productt = new ArrayList<>();
		List<ProductEntity> entities = (List<ProductEntity>) productRepository.findAll();
		if (entities != null) {
			productt = entities.stream()
					.map(entity -> convertEntityToDto(entity))
					.collect(Collectors.toList());
		}
		return productt;
	}
	
	private ProductDto convertEntityToDto(ProductEntity entity) {
		ProductDto dto = new ProductDto();
		if (entity != null) {
			dto.setPd_id(entity.getPd_id());
			dto.setShop_id(entity.getShop_id());
			dto.setPd_name(entity.getPd_name());
			dto.setPd_img(entity.getPd_img());
			dto.setPd_price(entity.getPd_price());
			dto.setPd_details(entity.getPd_details());
			dto.setPd_number(entity.getPd_number());
					
		}
		return dto;		
	}
	
	private ProductEntity convertDtoToEntit(ProductDto dto) {
		ProductEntity entity = new ProductEntity();
		if (dto != null) {
			entity.setPd_id(dto.getPd_id());
			entity.setShop_id(dto.getShop_id());
			entity.setPd_name(dto.getPd_name());
			entity.setPd_img(dto.getPd_img());
			entity.setPd_price(dto.getPd_price());
			entity.setPd_details(dto.getPd_details());
			entity.setPd_number(dto.getPd_number());		
		}
		return entity;		
	}

	@Override
	public ProductDto getProductByPD_id(Integer pd_id) throws Exception {
		ProductDto product = new ProductDto();
		if (pd_id > 0 ) {
			ProductEntity entity = productRepository.findById(pd_id).get();
			if (entity != null) {
				product = convertEntityToDto(entity);
				
			}
		} else {
			throw new NullPointerException("getProductByPD_id :: pd_id < 0! ");
		}
		return product;
	}
	
	@Override
	public List<ProductDto> getProductByShop_id(Integer shop_id) throws Exception {
		System.out.println("getProductByShop_id :: shop_id => " + shop_id);
		List<ProductDto> product = new ArrayList<>();
		if (shop_id != null ) {
			List<ProductEntity> entities = productRepository.findProductByShopId(shop_id);
			if (entities != null) {
				product = entities.stream().map(entity -> convertEntityToDto(entity)).collect(Collectors.toList());
				
			}
		} else {
			throw new NullPointerException("getProductByShop_id :: shop_id is null! ");
		}
		return product;
	}

}
