package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.dao.OrderRepository;
import com.it.dto.OrderDto;
import com.it.entity.OrderEntity;
import com.it.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired(required=false)
	OrderRepository orderRepository;

	@Override
	public OrderDto saveOrder(OrderDto orderDto) throws Exception {
		if (orderDto !=null) {
			OrderEntity entity = convertDtoToEntit(orderDto);
			orderRepository.save(entity);
		}else {
			throw new NullPointerException("saveorder :: orderDto is Null!");
		}
	
		return orderDto;
	}

	@Override
	public OrderDto updateOrder(OrderDto orderDto) throws Exception {
		if (orderDto !=null && orderDto.getOrder_id() > 0) {
			OrderEntity entity = convertDtoToEntit(orderDto);
			orderRepository.save(entity);
		}else {
			throw new NullPointerException("updateOrder :: OrderDto is Null or Order_id <0 !");
			
		}
		return orderDto;
	}

	@Override
	public Integer deleteOrderByOrder_id(Integer order_id) throws Exception {
		if(order_id > 0 ) {
			orderRepository.deleteById(order_id);
		}else {
			throw new NullPointerException("deleteOrderByOrder_id :: order_id <0");
		
		}
		return order_id;
	}

	@Override
	public List<OrderDto> selectAllOrder() throws Exception {
		List<OrderDto> orderr = new ArrayList<>();
		List<OrderEntity> entities = (List<OrderEntity>) orderRepository.findAll();
		if (entities != null) {
			orderr = entities.stream()
					.map(entity -> convertEntityToDto(entity))
					.collect(Collectors.toList());
		}
		return orderr;
	}
	
	private OrderDto convertEntityToDto(OrderEntity entity) {
		OrderDto dto = new OrderDto();
		if (entity != null) {
			dto.setOrder_id(entity.getOrder_id());
			dto.setId(entity.getId());
			dto.setShop_id(entity.getShop_id());
			dto.setPd_id(entity.getPd_id());
			dto.setOrder_name(entity.getOrder_name());
			dto.setOrder_date(entity.getOrder_date());
			dto.setOrder_number(entity.getOrder_number());
		
		}
		return dto;		
	}
	
	private OrderEntity convertDtoToEntit(OrderDto dto) {
		OrderEntity entity = new OrderEntity();
		if (dto != null) {
			entity.setOrder_id(dto.getOrder_id());
			entity.setId(dto.getId());
			entity.setShop_id(dto.getShop_id());
			entity.setPd_id(dto.getPd_id());
			entity.setOrder_name(dto.getOrder_name());
			entity.setOrder_date(dto.getOrder_date());
			entity.setOrder_number(entity.getOrder_number());
					
		}
		return entity;		
	}

	@Override
	public OrderDto getOrderByOrder_id(Integer order_id) throws Exception {
		OrderDto order = new OrderDto();
		if (order_id > 0 ) {
			OrderEntity entity = orderRepository.findById(order_id).get();
			if (entity != null) {
				order = convertEntityToDto(entity);
				
			}
		} else {
			throw new NullPointerException("getOrderByOrder_id :: order_id < 0! ");
		}
		return order;
	}

}