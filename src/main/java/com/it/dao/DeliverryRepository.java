package com.it.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.DeliverryEntity;


@Repository
public interface DeliverryRepository extends CrudRepository<DeliverryEntity, Integer > {

}
