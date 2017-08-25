package com.js.intbuffetproject.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.service.CategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CategoryController {

	private static final Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/categorycontroll", method = RequestMethod.GET)
	public ModelAndView addNewCategory() {
		ModelAndView modelAndView = new ModelAndView();
		Category category = new Category();
		modelAndView.setViewName("category");
		modelAndView.addObject("categories", categoryService.listCategories());
		modelAndView.addObject(category);
		return modelAndView;
	}

	@RequestMapping(value = "/newcategory", method = RequestMethod.POST)
	public String newCategory(@ModelAttribute("category") Category category, BindingResult result) {

		categoryService.addCategory(category);

		return "redirect:/categorycontroll";

	}

	@RequestMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Long id) {

		categoryService.removeCategory(id);

		return "redirect:/categorycontroll";
	}

	@RequestMapping("/updateCategory/{id}/{name}")
	public String updateCategory(@PathVariable("id") Long id, @PathVariable("name") String name) {

		categoryService.updateCategory(id, name);

		return "redirect:/categorycontroll";
	}

}
