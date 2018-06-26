package com.intellipaat.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateCustomerTest {
	private static WebDriver driver =null;
	public static void main(String[] args) throws InterruptedException {
		
		String expectToolTip = "Warning! Password recovery function is disabled as email settings are not configured.";
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
		driver.findElement(By.xpath("//a[text()='Projects & Customers']")).click();
		driver.findElement(By.id("createCustomerDiv")).click();
		
		if(driver.findElement(By.id("customerLightBox_titlePlaceholder")).getText().equals("Create New Customer")){
			
			driver.findElement(By.id("customerLightBox_nameField")).sendKeys("FirstCustomer");
			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys("FirstCustomer-Description");
			driver.findElement(By.id("customerLightBox_commitBtn")).click();
			Thread.sleep(5000);
			if(driver.findElement(By.xpath("//span[@class='successmsg']")).isDisplayed()){
				System.out.println("---PASS---");
			}else
			{
				System.out.println("---FAIL---");
			}
			
			
		}
		else
		{
			System.out.println("FAIL --- Create customer failed");
		}
		
		driver.findElement(By.id("logoutLink")).click();
		System.out.println("clicking on logout link ");
	
		System.out.println("closing browser.... ");
		driver.close();
		driver=null;

		
	}
	

}
