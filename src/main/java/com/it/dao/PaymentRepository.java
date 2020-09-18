package com.it.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.entity.OrderEntity;
import com.it.entity.PaymentEntity;



@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer >{

	List<PaymentEntity> findPaymentById(int id);
	
	@Query("select p from PaymentEntity p where p.order_ref = :order_ref")
	List<PaymentEntity> findPaymentByOrderRef(String order_ref);
}
