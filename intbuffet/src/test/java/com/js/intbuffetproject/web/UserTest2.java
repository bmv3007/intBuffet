/**
 * 
 */
package com.js.intbuffetproject.web;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Maria
 *
 */
public class UserTest2 {

	public static WebDriver driver;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Maria\\Programs\\ChromeDriver\\chromedriver.exe");
		System.out.println("test*********");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:7777/intbuffetproject/login1");
	}
	
	
		

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		/*  WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        logoutButton.click();*/
        driver.quit();
	}
    
	@Test
	public void test() {
		WebElement loginField = driver.findElement(By.id("username"));
		loginField.sendKeys("admin");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("admin");
	//	WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
	//	WebElement loginButton = driver.findElement(By.xpath("//input[@value='login']"));
		WebElement loginButton = driver.findElement(By.id("buttonlogin"));
		
		loginButton.click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement cartbefore = driver.findElement(By.id("totalItems"));
		String totalItemsbefore = cartbefore.getText();
		
	//	WebElement addProduct = driver.findElement(By.xpath("input[@value='Add new product']"));
		WebElement addProduct = driver.findElement(By.id("1"));
		// driver.navigate().refresh();
		addProduct.click();
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", addProduct);
		// driver.navigate().refresh();
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 addProduct.click();
		// driver.navigate().refresh();
		/* try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	//	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
		WebElement cartafter = driver.findElement(By.id("totalItems"));
		String totalItemsafter = cartafter.getText();
		
	//	WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
	//	String mailUser = profileUser.getText();
	//	Assert.assertEquals("autotestorgua@ukr.net", "autotestorgua@ukr.net");
	//	Assert.assertNotNull(addProduct);
		
		Assert.assertNotEquals(totalItemsbefore, totalItemsafter);
		
		
	
	}

}
