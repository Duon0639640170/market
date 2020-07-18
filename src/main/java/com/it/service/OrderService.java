package com.it.service;

import java.util.List;

import com.it.dto.OrderDto;


public interface OrderService {


	public OrderDto saveOrder(OrderDto orderDto) throws Exception;

	public OrderDto updateOrder(OrderDto orderDto) throws Exception;

	public Integer deleteOrderByOrder_id(Integer order_id) throws Exception;

	public List<OrderDto> selectAllOrder() throws Exception;
	
	public OrderDto getOrderByOrder_id (Integer order_id) throws Exception;
}
