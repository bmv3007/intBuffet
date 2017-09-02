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

/**
 * Class User with properties <b>username</b>, <b>password</b>, <b>email</b>,
 * <b>firstname</b>, <b>surname</b>, <b>birthday</b>, <b>address</b>.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

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

	/**
	 * Creates a new User with the given parameters: username, password, email,
	 * firstname, surname, birthday and address.
	 */
	public User(String username, String password, String email, String firstname, String surname, Date birthday,
			Address address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.surname = surname;
		this.birthday = birthday;
		this.address = address;
	}

	/**
	 * Creates a new User with the given parameters: username, password, email,
	 * firstname, surname, birthday.
	 */
	public User(String username, String password, String email, String firstname, String surname, Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.surname = surname;
		this.birthday = birthday;

	}

	/**
	 * Creates a new User with the given parameters: username, firstname,
	 * surname.
	 */
	public User(String username, String firstname, String surname) {

		this.username = username;
		this.firstname = firstname;
		this.surname = surname;

	}

	/**
	 * Creates a new empty User.
	 */
	public User() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
