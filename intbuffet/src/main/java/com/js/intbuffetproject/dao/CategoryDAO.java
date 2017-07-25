package com.js.intbuffetproject.dao;

import java.util.List;

import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.model.Product;

public interface CategoryDAO {

	void addCategory(Category category);

	List<Category> listCategories();

	void removeCategory(Long id);
	
	Category getCategoryByID(Long id);
	
}