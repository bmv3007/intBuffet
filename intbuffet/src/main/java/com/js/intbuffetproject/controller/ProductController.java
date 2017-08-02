package com.js.intbuffetproject.controller;

import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.dto.UserDTO;
import com.js.intbuffetproject.model.Address;
import com.js.intbuffetproject.model.Cart;
import com.js.intbuffetproject.model.Form_Order_Address;
import com.js.intbuffetproject.model.Item;
import com.js.intbuffetproject.model.Order;
import com.js.intbuffetproject.model.Product;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.AddressService;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.UserService;
import com.js.intbuffetproject.util.Util.Paymentmethod;
import com.js.intbuffetproject.util.Util.Deliverymethod;
import com.js.intbuffetproject.util.Util.Orderstatus;

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
		
		 return  "redirect:/addnewproduct";

	}

}
