package com.js.intbuffetproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class Address with properties <b>serialVersionUID</b>, <b>id</b>,
 * <b>country</b>, <b>city</b>, <b>postcode</b>, <b>street</b>,
 * <b>housenumber</b>, <b>apartment</b>.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

	static final long serialVersionUID = 3260689382642549142L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Address() {

	}

	/**
	 * Creates a new Address with the given parameters: id, country, city,
	 * postcode, street, housenumber, apartment.
	 */
	public Address(Long id, String country, String city, String postcode, String street, String housenumber,
			int apartment) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.postcode = postcode;
		this.street = street;
		this.housenumber = housenumber;
		this.apartment = apartment;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

}