/**
 * 
 */
package com.js.intbuffetproject.web;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.js.intbuffetproject.model.Category;
import com.js.intbuffetproject.service.CategoryService;
import com.js.intbuffetproject.service.impl.CategoryServiceImpl;

/**
 * @author Maria
 *
 */
//@ActiveProfiles(profiles = "test")
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath*:/WEB-INF/spring/root-context.xml", "classpath*:/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CategoryTest {
	
	@Configuration
    static class Config {

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public CategoryService categoryService() {
        	CategoryService categoryService = new CategoryServiceImpl();
            // set properties, etc.
            return categoryService;
        }
    }

	
	@Autowired
	private CategoryService categoryService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void listCategories() {
		List<Category> category = categoryService.listCategories();
		Assert.assertTrue(category.size() == 3);
	}

}
