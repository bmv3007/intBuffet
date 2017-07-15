package com.js.intbuffetproject.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.ProductDAO;
import com.js.intbuffetproject.model.Product;
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
    public void removeProduct(Integer id) {
    	productDAO.removeProduct(id);
    }
}