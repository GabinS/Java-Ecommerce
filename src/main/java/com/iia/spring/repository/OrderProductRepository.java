package com.iia.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.spring.entity.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {

}
