package com.js.intbuffetproject.dto;

import java.util.Date;
import java.util.List;

import com.js.intbuffetproject.model.Address;

/**
 * Class OrderDTO is DTO class for class Order.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public class OrderDTO {

	private Long id;


	private Date date;

	private UserDTO user;

	private Address address;

	private String paymentmethod;

	
	private String deliverymethod;

	private boolean paid;

	private String orderstatus;

	private double ordertotal;

	private boolean cart;

	public List<OrdersProductsDTO> ordersProductsDTO;

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(Long id, Date date, UserDTO user, Address address, String paymentmethod, String deliverymethod,
			boolean paid, String orderstatus, double ordertotal, boolean cart, List<OrdersProductsDTO> ordersProductsDTO) {
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
		this.ordersProductsDTO = ordersProductsDTO;
	}

	public Long getId() {
		return id;
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
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

	public boolean isPaid() {
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

	public List<OrdersProductsDTO> getOrdersProductsDTO() {
		return ordersProductsDTO;
	}

	public void setOrdersProductsDTO(List<OrdersProductsDTO> ordersProductsDTO) {
		this.ordersProductsDTO = ordersProductsDTO;
	}

	
	
}