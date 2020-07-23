package com.it.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.it.entity.SystembankEntity;

@Repository
public interface SystembankRepository extends CrudRepository<SystembankEntity, Integer> {

	
}
