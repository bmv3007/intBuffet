package com.js.intbuffetproject.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class OrdersProducts: binds id of product, id of order and quantity of
 * product.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */

@Entity
@Table(name = "orders_products")
public class OrdersProducts implements Serializable {

	static final long serialVersionUID = 3260689382642549142L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "products_id")
	private Product product;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orders_id")
	private Order order;

	// additional fields
	@Column(name = "quantity")
	private int quantity;

	public OrdersProducts() {
		super();

	}

	/**
	 * Creates a new OrdersProducts with the given parameters: id, product,
	 * order, quantity.
	 */
	public OrdersProducts(Long id, Product product, Order order, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
