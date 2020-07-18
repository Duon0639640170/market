package com.it.dao;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.it.entity.MarketEntity;


@Repository
public interface MarketRepository extends CrudRepository<MarketEntity, Integer>{

}
