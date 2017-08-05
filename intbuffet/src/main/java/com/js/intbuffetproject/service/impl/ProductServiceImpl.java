package com.js.intbuffetproject.service.impl;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.ProductDAO;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.OrdersProducts;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.SearchParameter;
import com.js.intbuffetproject.service.ProductService;
 
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
 
    @Autowired
    private ProductDAO productDAO;
 
    @Transactional
    public void addProduct(Product product) {
    	productDAO.addProduct(product);
    }
 
    @Transactional
    public List<Product> listProduct() {
 
        return productDAO.listProduct();
    }
 
    @Transactional
    public void removeProduct(Long id) {
    	productDAO.removeProduct(id);
    }

	@Override
	public Product getProductByID(Long id) {

		 return productDAO.getProductByID(id);
	}

	@Override
	public List<Product> searchProduct(String searchtext) {
		
		 return productDAO.searchProduct(searchtext);
	}

	@Override
	public List<Product> searchProductByParameters(SearchParameter searchParameter) {
		
		List<Product> listProduct = productDAO.searchProductByParameters(searchParameter);
		for(Product product:listProduct){
			product.setImage(product.getImage());
		}
		return listProduct;
	}

	@Override
	public List<OrdersProducts> fillProducts(Collection<Item> items) {

		List<OrdersProducts> ordersProducts = new ArrayList<>();
		for(Item item: items){
			Product product = getProductByID(item.getId());
			Integer sellQuantity = product.getSell_quantity()+item.getQuantity();
			productDAO.updateSellQuantity(product,sellQuantity);
			OrdersProducts orderProduct = new OrdersProducts();
			orderProduct.setProduct(product);
			orderProduct.setQuantity(item.getQuantity());
			
			ordersProducts.add(orderProduct);
		}
		return ordersProducts;
	}


@Override
public List<Integer> fillQuantities(Collection<Item> items) {
	
	List<Integer> listQuantity = new ArrayList<>();
	
	for(Item item: items){
		
		listQuantity.add(item.getQuantity());
	}
	return listQuantity;
}

}

