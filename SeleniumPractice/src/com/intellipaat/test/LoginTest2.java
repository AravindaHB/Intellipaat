package com.intellipaat.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest2 {
	//Create Global Variable
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8080/login.do");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		System.out.println("user name entered successfully");
		
		driver.findElement(By.name("pwd")).sendKeys("manager");
		System.out.println("password entered successfully");
		
		driver.findElement(By.id("loginButton")).click();
		System.out.println("clicked on login button successfully");
 
		driver.findElement(By.id("logoutLink")).click();
		System.out.println("clicking on logout link ");
	
		System.out.println("closing browser.... ");
		driver.close();
		driver=null;
		
		
	}

}
