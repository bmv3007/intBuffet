package com.js.intbuffetproject.model;

/**
 * Class Item with properties <b>serialVersionUID</b>, <b>id</b>, <b>name</b>,
 * <b>description</b>, <b>price</b>, <b>quantity</b>.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */

public class Item implements java.io.Serializable {

	static final long serialVersionUID = 3260689382642549142L;

	private Long id;

	private String name;

	private String description;

	private float price;

	private int quantity;

	/**
	 * Creates a new Item with the given parameters: id, name, description,
	 * price, quantity.
	 */
	public Item(Long id, String name, String description, float price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;

	}

	/**
	 * Creates a new Item with the given parameters: product, quantity.
	 */
	public Item(Product product, int quantity) {
		super();
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.quantity = quantity;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}