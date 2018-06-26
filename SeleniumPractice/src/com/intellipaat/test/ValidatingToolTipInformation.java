package com.intellipaat.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidatingToolTipInformation {

	static WebDriver driver = null;
	public static void main(String[] args) {
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
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		String actualToolTip = driver.findElement(By.xpath("//div[@class='popup_menu_icon warning_icon']")).getAttribute("title");
	
		if(actualToolTip.equals(expectToolTip)){
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
}
