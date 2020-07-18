package com.it.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.it.entity.ProductEntity;
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{

}
