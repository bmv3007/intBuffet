package com.js.intbuffetproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Product bean.
 * 
 * @author Maria Borovtsova
 */

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;
	
	@Column(name = "country")
	private String country;
 
	@Column(name = "city")
	private String city;
	
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "housenumber")
	private String housenumber;
	
	
	@Column(name = "apartment")
	private int apartment;
	
	@Column(name = "quantity")
	private int quantity;

	public Address() {
		
	}

	public Address(Long id, String country, String city, String postcode, String street, String housenumber,
			int apartment, int quantity) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.postcode = postcode;
		this.street = street;
		this.housenumber = housenumber;
		this.apartment = apartment;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public int getApartment() {
		return apartment;
	}

	public void setApartment(int apartment) {
		this.apartment = apartment;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}