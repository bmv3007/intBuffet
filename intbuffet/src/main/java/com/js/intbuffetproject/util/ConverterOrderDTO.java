package com.js.intbuffetproject.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.js.intbuffetproject.dto.OrderDTO;
import com.js.intbuffetproject.dto.OrdersProductsDTO;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.OrdersProducts;
import com.js.intbuffetproject.model.Product;

/**
 * Class ConverterOrderDTO is used to convert from order to orderDTO and vice versa.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Component
public class ConverterOrderDTO {

	@Autowired
	ConverterProductDTO converterProductDTO;

	/*
	 * public OrderDTO convertToDTO(Order order) {
	 * 
	 * ProductDTO productDTO = new ProductDTO(); CategoryDTO categoryDTO =
	 * converterCategoryDTO.convertToDTO(product.getCategory());
	 * productDTO.setCategory(categoryDTO);
	 * productDTO.setDescription(product.getDescription());
	 * productDTO.setId(product.getId());
	 * productDTO.setImage(product.getImage());
	 * productDTO.setName(product.getName());
	 * productDTO.setPrice(product.getPrice());
	 * productDTO.setQuantity(product.getQuantity());
	 * productDTO.setVegetarian(product.isVegetarian());
	 * productDTO.setWeight(product.getWeight()); return productDTO;
	 * 
	 * }
	 */

	public Order convertFromDTO(OrderDTO orderDTO) {

		Order order = new Order();

		order.setId(orderDTO.getId());
		//order.setUser(orderDTO.getUser());
		
		order.setAddress(orderDTO.getAddress());
		order.setDate(orderDTO.getDate());
		order.setDeliverymethod(orderDTO.getDeliverymethod());
		List<OrdersProducts> listOrdersProducts = new ArrayList<OrdersProducts>();
		if (orderDTO.getOrdersProductsDTO() != null) {
			for (OrdersProductsDTO OrdersProductsDTO : orderDTO.getOrdersProductsDTO()) {
				OrdersProducts ordersProducts = new OrdersProducts();
				Product product = converterProductDTO.convertFromDTO(OrdersProductsDTO.getProduct());
				ordersProducts.setId(OrdersProductsDTO.getId());
				ordersProducts.setOrder(order);
				ordersProducts.setProduct(product);
				ordersProducts.setQuantity(OrdersProductsDTO.getQuantity());

				listOrdersProducts.add(ordersProducts);
			}
		}
			order.setOrders_products(listOrdersProducts);
			order.setOrderstatus(orderDTO.getOrderstatus());
			order.setOrdertotal(orderDTO.getOrdertotal());
			order.setPaymentmethod(orderDTO.getPaymentmethod());

			return order;
		
	
	}
}
