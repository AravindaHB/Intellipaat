package com.intellipaat.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassDemo {
	static WebDriver driver = null;
	
	
	public static void main(String[] args) throws InterruptedException {
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
		
		driver.findElement(By.xpath("//a[div[text()='TASKS']]")).click();

		Thread.sleep(2000);
		WebElement showDropDown = driver.findElement(By.xpath("//select[@name='recordsPerPage']"));
		
		Select dropDown = new Select(showDropDown);
		
		dropDown.selectByIndex(3);
		
		Thread.sleep(2000);
		
		showDropDown = driver.findElement(By.xpath("//select[@name='recordsPerPage']"));
		
		dropDown = new Select(showDropDown);
		
		//List<WebElement> options = dropDown.getOptions();
		
		dropDown.selectByValue("20");
		
		Thread.sleep(3000);
		showDropDown = driver.findElement(By.xpath("//select[@name='recordsPerPage']"));
		
		dropDown = new Select(showDropDown);
		dropDown.selectByVisibleText("100");
		
		driver.findElement(By.id("logoutLink")).click();
		System.out.println("clicking on logout link ");
	
		System.out.println("closing browser.... ");
		driver.close();
		driver=null;

	}
	
}
