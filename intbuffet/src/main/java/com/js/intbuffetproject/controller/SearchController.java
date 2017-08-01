package com.js.intbuffetproject.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.SearchParameter;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SearchController {

	@Autowired
	private HttpSession httpSession;

	private static final Logger logger = Logger.getLogger(SearchController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/find", method = RequestMethod.GET, produces =  "application/json")
	public @ResponseBody // @ResponseBody - нужен, когда мы НЕ перенаправляем на
							List<Product> find(@RequestParam("categoryId") Long categoryId, @RequestParam("vegetarian") boolean vegetarian) {

		SearchParameter searchParameter = new SearchParameter();
		searchParameter.setCategoryID(categoryId);
		searchParameter.setVegetarian(vegetarian);
		
		
		//httpSession.setAttribute("currentProductList", productService.searchProductByParameters(searchParameter));
		
		logger.info("categoryId:" + categoryId + "vegetarian:" + vegetarian);
		//httpSession.setAttribute("currentProductList", productService.searchProductByParameters(searchParameter));
		
		return  productService.searchProductByParameters(searchParameter);
	}
	
	
	
	/*@RequestMapping(value = "/find", method = RequestMethod.POST)
	public ModelAndView find(Map<String, Object> map, @RequestParam("categoryId") Long categoryId, @RequestParam("vegetarian")  boolean vegetarian) {

		SearchParameter searchParameter = new SearchParameter();
		searchParameter.setCategoryID(categoryId);
		searchParameter.setVegetarian(vegetarian);
		
		ModelAndView modAndView = new ModelAndView();
		// logger.info("local = " + locale);
		map.put("productList1", productService.searchProductByParameters(searchParameter));
		//httpSession.setAttribute("currentProductList", productService.searchProductByParameters(searchParameter));
		modAndView.addAllObjects(map);
		modAndView.setViewName("index");
		logger.info("categoryId:" + categoryId + "vegetarian:" + vegetarian);
		//httpSession.setAttribute("productList1", productService.searchProductByParameters(searchParameter));
		
		return  modAndView;
	}
*/}
