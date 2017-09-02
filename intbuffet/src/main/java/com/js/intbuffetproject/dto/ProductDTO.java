package com.js.intbuffetproject.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class ProductDTO is DTO class for class Product.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public class ProductDTO implements java.io.Serializable {

	static final long serialVersionUID = 3260689382642549142L;

	private Long id;

	private String name;

	private CategoryDTO category;

	private String description;

	private float price;

	private boolean vegetarian;

	private int weight;

	private int quantity;

	private String image;

	public ProductDTO() {

	}

	public ProductDTO(Long id, String name, CategoryDTO category, String description, float price, boolean vegetarian,
			int weight, int quantity, String image) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.vegetarian = vegetarian;
		this.weight = weight;
		this.quantity = quantity;
		this.image = image;

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

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}