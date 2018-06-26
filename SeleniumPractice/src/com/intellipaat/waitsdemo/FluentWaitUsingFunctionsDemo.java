package com.intellipaat.waitsdemo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class FluentWaitUsingFunctionsDemo {

	static WebDriver driver = null;
	public static void main(String[] args) {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/login.do");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin");
		System.out.println("user name entered successfully");
		
		driver.findElement(By.name("pwd")).sendKeys("manager");
		System.out.println("password entered successfully");
		
		driver.findElement(By.id("loginButton")).click();
		System.out.println("clicked on login button successfully");
 
		
		driver.findElement(By.xpath("//a[div[text()='TASKS']]")).click();
		driver.findElement(By.xpath("//a[text()='Projects & Customers']")).click();
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 120);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[contains(text(),'Active Customers and Projects')]"))));
	
		FluentWait<WebElement> fWait = new FluentWait<WebElement>(driver.findElement(By.xpath("//td[contains(text(),'Active Customers and Projects')]")))
			.withTimeout(Duration.ofSeconds(40))
			.pollingEvery(Duration.ofMillis(100))
			.ignoring(NoSuchElementException.class)
			.ignoring(TimeoutException.class);
		
		
		fWait.until(new Function<WebElement, String>() {
			@Override
			public String apply(WebElement ele) {
				if(ele.getAttribute("class").equals("pagetitle")){
					System.out.println("Element Found....");
					return "pass";
				}
				else
				{
					System.out.println("Element not found....");
					return "fail";
				}
						
			}
			
		});
		System.out.println("Fluent wait is ended...");
		
				
		driver.findElement(By.xpath("//td[contains(text(),'Active Customers and Projects')]")).isDisplayed();
			
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logoutLink"))));

		driver.findElement(By.id("logoutLink")).click();
		System.out.println("clicking on logout link ");
	
		System.out.println("closing browser.... ");
		driver.close();
		driver=null;
	}
}
