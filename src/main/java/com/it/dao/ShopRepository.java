package com.it.dao;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.it.entity.ShopEntity;


@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Integer>{

}
