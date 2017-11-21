package com.iia.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.spring.entity.MyOrder;

public interface OrderRepository extends CrudRepository<MyOrder, Long>{


}
