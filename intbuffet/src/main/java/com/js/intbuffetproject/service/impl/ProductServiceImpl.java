package com.js.intbuffetproject.service.impl;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.ProductDAO;
import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Item;
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
		// TODO Auto-generated method stub
		 return productDAO.getProductByID(id);
	}

	@Override
	public List<Product> searchProduct(String searchtext) {
		// TODO Auto-generated method stub
		 return productDAO.searchProduct(searchtext);
	}

	@Override
	public List<Product> searchProductByParameters(SearchParameter searchParameter) {
		// TODO Auto-generated method stub
		List<Product> listProduct = productDAO.searchProductByParameters(searchParameter);
		for(Product product:listProduct){
			product.setImage(product.getImage());
		}
		return listProduct;
	}

	@Override
	public List<Product> fillProducts(Collection<Item> items) {
		// TODO Auto-generated method stub
		List<Product> listProducts = new ArrayList<>();
		for(Item item: items){
			
			listProducts.add(getProductByID(item.getId()));
		}
		return listProducts;
	}
}