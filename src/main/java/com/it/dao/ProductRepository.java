package com.it.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.it.entity.ProductEntity;
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
	
	@Query("SELECT product FROM ProductEntity product WHERE product.shop_id = :shop_id ")
	List<ProductEntity> findProductByShopId(@Param("shop_id") Integer shop_id);

//	@Query("SELECT product FROM ProductEntity product WHERE product.shop_id = :shop_id ")
//	ProductEntity findProductByShopId(@Param("shop_id") Integer shop_id);

	@Query("SELECT product FROM ProductEntity product WHERE product.type_id = :type_id ")
	List<ProductEntity> findProductByTypeId(@Param("type_id") Integer type_id);
	

}
