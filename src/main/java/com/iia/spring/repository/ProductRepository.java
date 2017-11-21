package com.iia.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.spring.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
}
