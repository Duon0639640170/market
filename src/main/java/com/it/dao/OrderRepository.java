package com.it.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.it.entity.OrderEntity;


@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer>{
	ArrayList<OrderEntity> findAllById(@Param("id") Integer id);
	
}
