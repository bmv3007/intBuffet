package com.js.intbuffetproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.CategoryDAO;
import com.js.intbuffetproject.dto.CategoryDTO;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.SendJMS;

/**
 * Class CategoryServiceImpl contains business logic related to class Category.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private SendJMS sendJMS;

	@Transactional
	public void addCategory(Category category) {
		categoryDAO.addCategory(category);
	}

	@Transactional
	public void updateCategory(Long id, String name) {
		
		categoryDAO.updateNameCategory(name, id);
		sendJMS.sendJMS();

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

		return categoryDAO.getCategoryByID(id);
	}
	
	@Override
	public List<Category> getCategoryByName(String name) {

		return categoryDAO.getCategoryByName(name);
	}

	@Override
	public CategoryDTO converterCategoryDTO(Category category) {

		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}

}