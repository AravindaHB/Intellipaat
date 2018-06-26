package com.intellipaat.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingMultipleElements {
	static WebDriver driver = null;
	
	
	public static void main(String[] args) {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.gsmarena.com/apple_ipad_9_7_(2018)-9142.php");
		
		List<WebElement> elements = driver.findElements(By.xpath("//tbody[tr[th[text()='Features']]]//td[@class='nfo']"));
//		
//		for (WebElement webElement : features) {
//			
//			System.out.println(webElement.getText());
//			
//		}
//		
		
//		Iterator<WebElement> it  = features.iterator();
//		while(it.hasNext()){
//			WebElement element = it.next();
//			System.out.println(element.getText());
//			
//		}
//		
		
		for (int i = 0; i < elements.size(); i++) {
			WebElement element = elements.get(i);
			System.out.println(element.getText());
			
		}
		
	}

}
