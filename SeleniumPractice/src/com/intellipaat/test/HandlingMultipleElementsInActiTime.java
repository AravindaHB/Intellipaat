package com.intellipaat.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingMultipleElementsInActiTime {
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
		
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//tr[td[text()='Project-1']]//input"));
		
		for (WebElement webElement : elements) {
			
			if(webElement.isDisplayed())
			{
				System.out.println("Element is displayed");
				if(webElement.isEnabled())
				{
					System.out.println("Element is Enabled ");
					if(!(webElement.isSelected())){
						System.out.println("element is not selected so clicking on element");
							webElement.click();
					}else{
						System.out.println("element is already selected");
					}
				
				}else
				{
					System.out.println("element is not enabled");
				}
			}else
			{
				System.out.println("element not displayed");
			}
			
			
		}
		
		driver.findElement(By.id("logoutLink")).click();
		System.out.println("clicking on logout link ");
	
		System.out.println("closing browser.... ");
		driver.close();
		driver=null;

	}
	
}
