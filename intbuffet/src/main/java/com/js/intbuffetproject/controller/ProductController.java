package com.js.intbuffetproject.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.exception.FileIsEmptyException;
import com.js.intbuffetproject.model.Product;

import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.ProductService;
import com.js.intbuffetproject.service.StatisticService;
import com.js.intbuffetproject.util.FileHolder;

/**
* Handles requests for products: /addnewproduct,  /newProduct, /get_products.
* 
* @author Maria Borovtsova
* 
* @version 1.1
*/
@Controller
public class ProductController {

	private static final Logger LOG = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private StatisticService statisticService;

	/**
	 * Get page to add new product
	 * @param product 
	 * @return ModelAndView with View product 
	 */
	@RequestMapping(value = "/addnewproduct", method = RequestMethod.GET)
	public ModelAndView addNewProduct(@ModelAttribute("product") Product product,
			@ModelAttribute("message") String message) {

		ModelAndView modelAndView = new ModelAndView();
		if (product == null)
			product = new Product();
		modelAndView.setViewName("product");
		modelAndView.addObject("categories", categoryService.listCategories());
		modelAndView.addObject(product);

		return modelAndView;
	}

	/**
	 * Add new product
	 * @param product 
	 * @return ModelAndView with View product 
	 */
	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute("product") Product product, BindingResult result,
			RedirectAttributes redirectAttributes) {

		try {

			productService.addProduct(product);
			redirectAttributes.addFlashAttribute("message", "Operation performed successfully...");
			redirectAttributes.addFlashAttribute("product", null);

		} catch (IOException e) {

			redirectAttributes.addFlashAttribute("message", e.getMessage());
			redirectAttributes.addFlashAttribute("product", product);

		} catch (FileIsEmptyException e) {

			redirectAttributes.addFlashAttribute("message", e.getExceptionMsg());
			redirectAttributes.addFlashAttribute("product", product);

		}

		return "redirect:/addnewproduct";

	}
	
	
	@RequestMapping(value= "/get_products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProducts(){
		 
		 return statisticService.getTopProductsDTO();
		 
	 }

}
