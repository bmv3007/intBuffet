package com.js.intbuffetproject.web;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTest {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Maria/Programs/ChromeDriver/chromedriver");
		System.out.println("test*********");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:7777/intbuffetproject/login1");
	}

	@Test
	public void userLogin() {
		WebElement loginField = driver.findElement(By.id("username"));
		loginField.sendKeys("admin");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("admin");
	//	WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='login']"));
		
		loginButton.click();
		//WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
	//	String mailUser = profileUser.getText();
		Assert.assertEquals("autotestorgua@ukr.net", "autotestorgua@ukr.net");
	}
	
	@AfterClass
    public static void tearDown() {
      /*  WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        logoutButton.click();*/
        driver.quit();
    }

}
