package com.js.test.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.js.intbuffetproject.dao.impl.CategoryDAOImpl;
import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.service.SendJMS;
import com.js.intbuffetproject.service.impl.CategoryServiceImpl;

public class CategoryServiceImplTest {

	@Mock
	private CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();

	@InjectMocks
	private CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();

	@Mock
	private SendJMS sendJMS;

	Category category;

	ArrayList<Category> listCategories = new ArrayList<>();

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		category = new Category(1L, "salad");

		listCategories.add(category);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCategory() {

		categoryServiceImpl.addCategory(category);

		verify(categoryDAOImpl).addCategory(category);

	}

	@Test
	public void testUpdateCategory() {

		categoryServiceImpl.updateCategory(category.getId(), category.getName());

		verify(categoryDAOImpl).updateNameCategory(category.getName(), category.getId());

	}

	@Test
	public void testListCategories() {

		when(categoryDAOImpl.listCategories()).thenReturn(listCategories);

		List<Category> listCategoriesFound = categoryServiceImpl.listCategories();

		Assert.assertEquals(listCategoriesFound, listCategories);

	}

}
