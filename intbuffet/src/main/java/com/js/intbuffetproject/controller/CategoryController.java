package com.js.intbuffetproject.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.js.intbuffetproject.exception.CategoryException;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.service.CategoryService;

/**
* Handles requests for categories: /newcategory, /deleteCategory/{id}, /updateCategory/{id}/{name}, /categorycontroll.
* 
* @author Maria Borovtsova
* 
* @version 1.1
*/
@Controller
public class CategoryController {

	private static final Logger LOG = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * Go to page to add new category
	 * 
	 * @return ModelAndView with View category
	 */
	@RequestMapping(value = "/categorycontroll", method = RequestMethod.GET)
	public ModelAndView newCategory() {
		ModelAndView modelAndView = new ModelAndView();
		Category category = new Category();
		modelAndView.setViewName("category");
		modelAndView.addObject("categories", categoryService.listCategories());
		modelAndView.addObject(category);
		return modelAndView;
	}
	
	/**
	 * Add new category
	 * @param category 
	 */
	@RequestMapping(value = "/newcategory", method = RequestMethod.POST)

	public String addNewCategory(@ModelAttribute("category") Category category, BindingResult result) {

		categoryService.addCategory(category);

		return "redirect:/categorycontroll";

	}

	/**
	 * Delete category
	 * @param id -  category's id
	 */
	@RequestMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Long id) {

		categoryService.removeCategory(id);

		return "redirect:/categorycontroll";
	}

	/**
	 * Update category
	 * @param id -  category's id
	 * @param name - new category's name
	 */
	@RequestMapping("/updateCategory/{id}/{name}")
	public String updateCategory(@PathVariable("id") Long id, @PathVariable("name") String name) {

		categoryService.updateCategory(id, name);

		return "redirect:/categorycontroll";
	}

}
