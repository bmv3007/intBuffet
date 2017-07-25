package com.js.intbuffetproject.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.ProductDAO;
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
		return productDAO.searchProductByParameters(searchParameter);
	}
}