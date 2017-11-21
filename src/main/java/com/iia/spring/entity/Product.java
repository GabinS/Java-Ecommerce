package com.iia.spring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, unique=true)
	private String name;
	private String description;
	private int quantity;
	private boolean dead;
	private float price;
	@OneToMany(mappedBy="OrderProduct")
    private List<OrderProduct> ordersproducts;
	
	protected Product() {}

	/**
	 * Constructor of Product
	 * @param name
	 * @param description
	 * @param quantity
	 * @param dead
	 * @param price
	 */
	public Product(String name, String description, int quantity, boolean dead, float price) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.dead = dead;
		this.price = price;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the dead
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * @param dead the dead to set
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
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
		if(ordersproduct.getProduct() != this) {
			ordersproduct.setProduct(this);
		}
	}
	
		

}
