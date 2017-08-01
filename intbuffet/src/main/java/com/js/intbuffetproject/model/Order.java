package com.js.intbuffetproject.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Product bean.
 * 
 * @author Maria Borovtsova
 */

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name = "date")
	private  Date date;

	@ManyToOne //many orders by one client
	@JoinColumn(name="client")
	private User user;

	@ManyToOne //many orders by one address
	@JoinColumn(name="address")
	private Address address;

	@Column(name = "paymentmethod")
	private String paymentmethod;

	@Column(name = "deliverymethod")
	private String deliverymethod;

	@Column(name = "paid") //? boolean ??
	private boolean paid;

	@Column(name = "orderstatus")
	private String orderstatus;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "orders_products", 
	joinColumns = @JoinColumn(name = "orders_id"), 
	inverseJoinColumns = @JoinColumn(name = "products_id"))
	private List<Product> products;

	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, Date date, User user, Address address, String paymentmethod, String deliverymethod,
			boolean paid, String orderstatus) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.address = address;
		this.paymentmethod = paymentmethod;
		this.deliverymethod = deliverymethod;
		this.paid = paid;
		this.orderstatus = orderstatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProducts(Product products) {
		this.products.add(products);
	}


}