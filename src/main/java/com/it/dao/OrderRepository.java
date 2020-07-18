package com.it.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.it.entity.OrderEntity;


@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer>{

	
}
