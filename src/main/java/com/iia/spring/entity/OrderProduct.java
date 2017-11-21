package com.iia.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderProduct {
	
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn
	private MyOrder order;
	@ManyToOne
	@JoinColumn
	private Product product;
	
	/**
	 * Constructor of OrderProduct
	 * @param order
	 * @param product
	 */
	public OrderProduct(MyOrder order, Product product) {
		super();
		this.order = order;
		this.product = product;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the order
	 */
	public MyOrder getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(MyOrder order) {
		this.order = order;
		if (!order.getOrdersproducts().contains(this)) {
			order.getOrdersproducts().add(this);
		}
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
		if (!product.getOrdersproducts().contains(this)) {
			product.getOrdersproducts().add(this);
		}
	}
}
