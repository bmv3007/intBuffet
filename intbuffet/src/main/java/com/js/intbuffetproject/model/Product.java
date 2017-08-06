package com.js.intbuffetproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Product bean.
 * 
 * @author Maria Borovtsova
 */

@Entity
@Table(name = "products")
@Proxy(lazy = false)
public class Product implements java.io.Serializable {

	static final long serialVersionUID = 3260689382642549142L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private float price;

	@Column(name = "vegetarian")
	private boolean vegetarian;

	@Column(name = "weight")
	private int weight;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "image")
	private String image;

	@Column(name = "sell_quantity")
	private int sell_quantity;

	@OneToMany(mappedBy = "product")
	public List<OrdersProducts> orders_products;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "products_ingredients", joinColumns = @JoinColumn(name = "products_id"), inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
	@JsonIgnore
	private List<Ingredient> ingredients;

	public Product(Long id, String name, Category category, String description, float price, boolean vegetarian,
			int weight, int quantity, String image, List<Ingredient> ingredients) {
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
		this.ingredients = ingredients;
	}

	public Product(Long id, String name, Category category, String description, float price, boolean vegetarian,
			int weight, int quantity, String image, int sell_quantity, List<OrdersProducts> orders_products,
			List<Ingredient> ingredients) {
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
		this.sell_quantity = sell_quantity;
		this.orders_products = orders_products;
		this.ingredients = ingredients;
	}

	public Product() {

	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setId(Long id) {
		this.id = id;
	}

	public int getSell_quantity() {
		return sell_quantity;
	}

	public void setSell_quantity(int sell_quantity) {
		this.sell_quantity = sell_quantity;
	}

	public List<OrdersProducts> getOrders_products() {
		return orders_products;
	}

	public void setOrders_products(List<OrdersProducts> orders_products) {
		this.orders_products = orders_products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}