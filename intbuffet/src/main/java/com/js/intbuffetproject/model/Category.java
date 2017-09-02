package com.js.intbuffetproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class Category with properties <b>serialVersionUID</b>, <b>id</b>,
 * <b>name</b>.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */

@Entity
@Table(name = "categories")
public class Category implements java.io.Serializable {

	static final long serialVersionUID = 3260689382642549142L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	/**
	 * Creates a new empty Category.
	 */
	public Category() {

	}

	/**
	 * Creates a new Category with the given parameters: id, name.
	 */
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}