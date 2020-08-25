package com.it.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.entity.ShopEntity;


@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Integer> {
	
	@Query("SELECT shop FROM ShopEntity shop WHERE shop.id = :id ")
	ShopEntity findShopByUserId(@Param("id") Integer id);

}
