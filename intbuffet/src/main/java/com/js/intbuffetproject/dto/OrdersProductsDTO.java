package com.js.intbuffetproject.dto;

/**
 * Class OrdersProductsDTO is DTO class for class OrdersProducts.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public class OrdersProductsDTO {

	private Long id;

	private ProductDTO product;

	private OrderDTO order;

	private int quantity;

	public OrdersProductsDTO() {
		super();

	}

	public OrdersProductsDTO(Long id, ProductDTO product, OrderDTO order, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
