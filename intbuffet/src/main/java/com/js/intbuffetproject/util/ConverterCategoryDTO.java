package com.js.intbuffetproject.util;

import org.springframework.stereotype.Component;

import com.js.intbuffetproject.dto.CategoryDTO;
import com.js.intbuffetproject.model.Category;

/**
 * Class ConverterCategoryDTO is used to convert from category to categoryDTO and vice versa.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Component
public class ConverterCategoryDTO {

	public CategoryDTO convertToDTO(Category category) {

		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;

	}

	public Category convertFromDTO(CategoryDTO categoryDTO) {

		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		return category;

	}

}
