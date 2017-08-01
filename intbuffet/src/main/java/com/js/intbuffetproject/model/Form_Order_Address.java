package com.js.intbuffetproject.model;

import java.util.Date;

public class Form_Order_Address {
	
	public Address address;
	
	public Order order;
	
	public Form_Order_Address(Address address, Order order) {
		super();
		this.address = address;
		this.order = order;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}
