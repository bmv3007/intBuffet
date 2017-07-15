package com.js.intbuffetproject.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
		@Autowired
		private ProductService productService;

	
		@RequestMapping("/index")
		@ResponseBody
		public ModelAndView listProducts(Map<String, Object> map, Locale locale) {
			ModelAndView modAndView = new ModelAndView();
		//	logger.info("local = " + locale);
			map.put("contact", new Product());
			map.put("productList", productService.listProduct());
			System.out.println("list = " + productService.listProduct().toArray());
			modAndView.addAllObjects(map);
			modAndView.setViewName("index");

			return modAndView;
		}

		@RequestMapping("/")
		public String home(Locale local) {
			return "redirect:/index";
		}
	
}
