package com.iia.spring.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MyOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date date;
	private State state;
	private float totalprice;
	@ManyToOne
	@JoinColumn
	private Customer customer;
	@OneToMany(mappedBy="OrderProduct")
    private List<OrderProduct> ordersproducts;
	
	/**
	 * Constructor of Order
	 * @param date2
	 * @param state
	 * @param totalprice
	 */
	public MyOrder(Date date2, State state, float totalprice) {
		super();
		this.date = date2;
		this.state = state;
		this.totalprice = totalprice;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * @return the totalprice
	 */
	public float getTotalprice() {
		return totalprice;
	}
	/**
	 * @param totalprice the totalprice to set
	 */
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
		if(!customer.getOrders().contains(this)) {
			customer.getOrders().add(this);
		}
	}

	/**
	 * @return the ordersproducts
	 */
	public List<OrderProduct> getOrdersproducts() {
		return ordersproducts;
	}

	/**
	 * @param ordersproduct the ordersproduct to add
	 */
	public void addOrdersproducts(OrderProduct ordersproduct) {
		this.ordersproducts.add(ordersproduct);
		if(ordersproduct.getOrder() != this) {
			ordersproduct.setOrder(this);
		}
	}
	
}
