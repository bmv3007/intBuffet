package com.js.intbuffetproject.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class Order with properties <b>id</b>, <b>date</b>, <b>user</b>,
 * <b>address</b>, <b>paymentmethod</b>, <b>deliverymethod</b>, <b>paid</b>,
 * <b>orderstatus</b>, <b>ordertotal</b>, <b>cart</b>, <b>orders_products</b>.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	static final long serialVersionUID = 3260689382642549142L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "client")
	private User user;

	@ManyToOne
	@JoinColumn(name = "address")
	private Address address;

	@Column(name = "paymentmethod")
	private String paymentmethod;

	@Column(name = "deliverymethod")
	private String deliverymethod;

	@Column(name = "paid")
	private boolean paid;

	@Column(name = "orderstatus")
	private String orderstatus;

	@Column(name = "ordertotal")
	private double ordertotal;

	@Column(name = "cart")
	private boolean cart;

	@OneToMany(mappedBy = "order")
	public List<OrdersProducts> orders_products;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a new Order with the given parameters: id, date, user, address,
	 * paymentmethod, deliverymethod, paid, orderstatus, ordertotal, cart,
	 * orders_products.
	 */
	public Order(Long id, Date date, User user, Address address, String paymentmethod, String deliverymethod,
			boolean paid, String orderstatus, double ordertotal, boolean cart, List<OrdersProducts> orders_products) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.address = address;
		this.paymentmethod = paymentmethod;
		this.deliverymethod = deliverymethod;
		this.paid = paid;
		this.orderstatus = orderstatus;
		this.ordertotal = ordertotal;
		this.cart = cart;
		this.orders_products = orders_products;
	}

	public Long getId() {
		return id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public String getDeliverymethod() {
		return deliverymethod;
	}

	public void setDeliverymethod(String deliverymethod) {
		this.deliverymethod = deliverymethod;
	}

	public boolean getPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public double getOrdertotal() {
		return ordertotal;
	}

	public void setOrdertotal(double ordertotal) {
		this.ordertotal = ordertotal;
	}

	public boolean isCart() {
		return cart;
	}

	public void setCart(boolean cart) {
		this.cart = cart;
	}

	public List<OrdersProducts> getOrders_products() {
		return orders_products;
	}

	public void setOrders_products(List<OrdersProducts> orders_products) {
		this.orders_products = orders_products;
	}

}