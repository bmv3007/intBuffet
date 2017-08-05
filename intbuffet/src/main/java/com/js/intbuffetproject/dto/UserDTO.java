package com.js.intbuffetproject.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import com.js.intbuffetproject.model.Address;

public class UserDTO {

	private String username;

	
	private String email;

	
	private String firstname;

	
	private String surname;

	
	private Date birthday;

	private Address address;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public UserDTO(String username, String email, String firstname, String surname, Date birthday, Address address,
			ArrayList<GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.surname = surname;
		this.birthday = birthday;
		this.address = address;
		this.authorities = authorities;
	}

	Collection<? extends GrantedAuthority> authorities;

	public UserDTO(String username, String email, String firstname, String surname, Date birthday,
			Address address) {
		super();
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.surname = surname;
		this.birthday = birthday;
		this.address = address;
	}

	public UserDTO() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
