package com.js.intbuffetproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class UserWithoutPasswordDTO {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "surname")
	private String surname;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;

	@OneToOne
	@JoinColumn(name = "address", referencedColumnName = "id")
	private Address address;

	public UserWithoutPasswordDTO(String username, String email, String firstname, String surname, Date birthday,
			Address address) {
		super();
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.surname = surname;
		this.birthday = birthday;
		this.address = address;
	}

	public UserWithoutPasswordDTO() {

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
