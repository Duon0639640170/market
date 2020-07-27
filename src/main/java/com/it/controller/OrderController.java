package com.it.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.it.dto.OrderDto;
import com.it.service.OrderService;


@RestController
public class OrderController {

	@Autowired(required=false)
	
	OrderService orderservice;
	
	@PostMapping("/order/save")
	public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto) throws Exception{		
		orderservice.saveOrder(orderDto);
		return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
	}
	
	@PostMapping("/order/update")
	public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) throws Exception{
		orderservice.updateOrder(orderDto);
		return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/order/{order_id}")
	public ResponseEntity<Integer> deleteOrderByOrder_id(@PathVariable Integer order_id) throws Exception{
		orderservice.deleteOrderByOrder_id(order_id);
		return new ResponseEntity<Integer>(order_id, HttpStatus.OK);		
	}
		@GetMapping("/order/{order_id}")
	public ResponseEntity<OrderDto> getOrderByOrder (@PathVariable Integer order_id) throws Exception{
			OrderDto orderDto = orderservice.getOrderByOrder_id(order_id);
		return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);		
	}
		@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/order")
	public ResponseEntity<List<OrderDto>> getAllOrder() throws Exception{
		List<OrderDto> response = orderservice.selectAllOrder();
		return new ResponseEntity<List<OrderDto>>(response, HttpStatus.OK);
	}
		@PostMapping("/order/saveAll")
		public ResponseEntity<ArrayList<OrderDto>> saveOrderAll(@RequestBody ArrayList<OrderDto> orders) throws Exception{		
			if (orders != null) {
				for (OrderDto orderDto : orders) {
					orderservice.saveOrder(orderDto);
				}
			}
			return new ResponseEntity<ArrayList<OrderDto>>(orders, HttpStatus.OK);
		}
		
		@GetMapping("/orders/{id}")
		public ResponseEntity<ArrayList<OrderDto>> getOrderById(@PathVariable Integer id) throws Exception {
			ArrayList<OrderDto> orders = orderservice.getOrdersById(id);
			return new ResponseEntity<ArrayList<OrderDto>>(orders, HttpStatus.OK);
		}
}
