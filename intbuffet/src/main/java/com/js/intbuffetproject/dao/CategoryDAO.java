package com.js.intbuffetproject.dao;

import java.util.List;

import com.js.intbuffetproject.model.Category;

public interface CategoryDAO {

	void addCategory(Category category);
	
	void updateCategory(Category category);
	
	void updateNameCategory(String name, Long id);

	List<Category> listCategories();

	void removeCategory(Long id);
	
	Category getCategoryByID(Long id);
	
	List<Category> getCategoryByName(String name);
	
}