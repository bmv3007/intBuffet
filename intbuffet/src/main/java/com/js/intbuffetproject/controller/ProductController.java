package com.js.intbuffetproject.controller;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Product;

import com.js.intbuffetproject.service.AddressService;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {

	@Autowired
	private HttpSession httpSession;

	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addnewproduct", method = RequestMethod.GET)
	public ModelAndView addNewProduct() {
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		modelAndView.setViewName("product");
		modelAndView.addObject("categories", categoryService.listCategories());
		modelAndView.addObject(product);
		return modelAndView;
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute("product") Product product, BindingResult result) {

		productService.addProduct(product);

		return "redirect:/addnewproduct";

	}

}
