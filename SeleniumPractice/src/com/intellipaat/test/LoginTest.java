package com.intellipaat.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	//Create Global Variable
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/login.do");
		
		WebElement usernameTextBox = driver.findElement(By.id("username"));
		WebElement passwordTextBox = driver.findElement(By.name("pwd"));
		WebElement loginButton = driver.findElement(By.id("loginButton"));
		
		usernameTextBox.sendKeys("admin");
		System.out.println("user name entered successfully");
		passwordTextBox.sendKeys("manager");
		System.out.println("password entered successfully");
		loginButton.click();
		System.out.println("clicked on login button successfully");
		
		
		WebElement logoutLink = driver.findElement(By.id("logoutLink"));
		System.out.println("clicking on logout link ");
		logoutLink.click();
		
		System.out.println("closing browser.... ");
		driver.close();
		driver=null;
			
		
		
	}

}
