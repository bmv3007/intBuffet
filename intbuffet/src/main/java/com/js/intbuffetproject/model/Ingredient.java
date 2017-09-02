package com.js.intbuffetproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class Ingredient with properties <b>id</b>, <b>name</b>.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */

@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;
}
