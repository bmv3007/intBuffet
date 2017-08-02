package com.js.intbuffetproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.CategoryDAO;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional
	public void addCategory(Category category) {
		categoryDAO.addCategory(category);
	}

	@Transactional
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}

	@Transactional
	public List<Category> listCategories() {

		return categoryDAO.listCategories();
	}

	@Transactional
	public void removeCategory(Long id) {
		categoryDAO.removeCategory(id);
	}

	@Override
	public Category getCategoryByID(Long id) {
		// TODO Auto-generated method stub
		return categoryDAO.getCategoryByID(id);
	}

}