package com.it.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.it.entity.OrderEntity;
import com.it.entity.ProductEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
	
	ArrayList<OrderEntity> findAllById(@Param("id") Integer id);

	ArrayList<OrderEntity> findAllByShopId(@Param("shop_id") Integer shop_id);
	
	@Query("SELECT order FROM OrderEntity order WHERE order.pd_id = :pd_id ")
	List<OrderEntity> findOrderByPDId(@Param("pd_id") Integer pd_id);
}
