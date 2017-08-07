package com.js.intbuffetproject.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Product;

import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.util.FileHolder;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/addnewproduct", method = RequestMethod.GET)
	public ModelAndView addNewProduct(ModelMap model) {

		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		modelAndView.setViewName("product");
		modelAndView.addObject("categories", categoryService.listCategories());
		modelAndView.addObject(product);
		FileHolder fileHolder = new FileHolder();
		model.addAttribute("fileHolder", fileHolder);
		modelAndView.addObject(model);
		return modelAndView;
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute("product") Product product, BindingResult result,
			@ModelAttribute("category") Category category, @RequestParam("fileHolder") MultipartFile file) {
		logger.info("product.getCategory( =" + product.getCategory());
		logger.info("categories =" + category.getName());

		productService.addProduct(product, null, file);

		return "redirect:/addnewproduct";

	}

}
