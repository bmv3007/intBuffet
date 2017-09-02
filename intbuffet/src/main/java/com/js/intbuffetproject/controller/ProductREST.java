package com.js.intbuffetproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.StatisticService;

//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/rs/json")
public class ProductREST {
	
	@Autowired
	private StatisticService statisticService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value= "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProducts(){
		 
		 return statisticService.getTopProductsDTO();
		 
	 }

}
