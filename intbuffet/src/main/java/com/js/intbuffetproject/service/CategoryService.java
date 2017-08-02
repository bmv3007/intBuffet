package com.js.intbuffetproject.service;

import java.util.List;

import com.js.intbuffetproject.model.Category;


public interface CategoryService {

	void addCategory(Category category);
	
	void updateCategory(Category category);

	List<Category> listCategories();
	
	Category getCategoryByID(Long id);

	void removeCategory(Long id);
	
}