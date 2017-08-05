package com.js.intbuffetproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ingredient bean.
 * 
 * @author Maria Borovtsova
 */

@Entity
@Table(name = "ingredients")
public class Ingredient {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;
}
