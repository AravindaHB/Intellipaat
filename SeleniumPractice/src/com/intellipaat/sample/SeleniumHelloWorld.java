package com.intellipaat.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumHelloWorld {

	public static void main(String[] args) {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		//driver.close();
		System.out.println("main ended");
		
		
	}
}
