package com.intellipaat.waitsdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitDemo {

	static WebDriver driver = null;
	public static void main(String[] args) {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/login.do");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin");
		System.out.println("user name entered successfully");
		
		driver.findElement(By.name("pwd")).sendKeys("manager");
		System.out.println("password entered successfully");
		
		driver.findElement(By.id("loginButton")).click();
		System.out.println("clicked on login button successfully");
 
		
		driver.findElement(By.xpath("//a[div[text()='TASKS']]")).click();
		driver.findElement(By.xpath("//a[text()='Projects & Customers']")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[contains(text(),'Active Customers and Projects')]"))));
		
		driver.findElement(By.xpath("//td[contains(text(),'Active Customers and Projects')]")).isDisplayed();
			
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logoutLink"))));

		driver.findElement(By.id("logoutLink")).click();
		System.out.println("clicking on logout link ");
	
		System.out.println("closing browser.... ");
		driver.close();
		driver=null;
	}
}
