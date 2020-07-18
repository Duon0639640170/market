package com.it.dao;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.it.entity.ReportEntity;

@Repository
public interface ReportRepository extends CrudRepository<ReportEntity, Integer>{

}
