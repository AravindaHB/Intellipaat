package com.intellipaat.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOperations {
	static WebDriver driver = null;
	
	
	public static void main(String[] args) {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8080/login.do");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Full screen 
		driver.manage().window().fullscreen();
		
		//to click on back button on ur browser
		driver.navigate().back();
		
		//to click on forward button
		driver.navigate().forward();
		
		// to refresh the page
		driver.navigate().refresh();
		
		//to read current URL of ur application
		driver.getCurrentUrl();
		
		
		driver.navigate().to("http://localhost:8080/login.do");
		
		driver.getTitle();
		
		
	}
}
