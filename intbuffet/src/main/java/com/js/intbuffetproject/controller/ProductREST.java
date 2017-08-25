package com.js.intbuffetproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.service.StatisticService;

@RestController
@RequestMapping("/rs/json")
public class ProductREST {
	
	@Autowired
	private StatisticService statisticService;
	
	@RequestMapping(value= "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProducts(){
		 
		 return statisticService.getTopProductsDTO();
		 
	 }

}