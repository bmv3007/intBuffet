package com.js.intbuffetproject.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.js.intbuffetproject.dto.CategoryDTO;
import com.js.intbuffetproject.dto.ProductDTO;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Product;

/**
 * @see com.js.intbuffetproject.service.impl.CategoryServiceImpl
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public interface CategoryService {

	void addCategory(Category category);
	
	void updateCategory(Long id, String name);

	List<Category> listCategories();
	
	Category getCategoryByID(Long id);
	
	List<Category> getCategoryByName(String name);

	void removeCategory(Long id);
	
	CategoryDTO converterCategoryDTO(Category category);
	
}