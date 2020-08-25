package com.it.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.it.entity.TypeEntity;

@Repository
public interface TypeRepository extends CrudRepository<TypeEntity, Integer> {
	
}
