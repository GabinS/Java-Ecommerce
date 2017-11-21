package com.iia.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.spring.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
}
