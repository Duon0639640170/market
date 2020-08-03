package com.it.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.it.entity.PaymentEntity;



@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer >{

	List<PaymentEntity> findPaymentById(int id);
	
}
