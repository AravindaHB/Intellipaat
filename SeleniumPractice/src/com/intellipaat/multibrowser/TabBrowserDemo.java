package com.intellipaat.multibrowser;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabBrowserDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Flights']")).click();
		waitForLoad(driver);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> iterator = ids.iterator();
		String parentID = iterator.next();
		System.out.println("Parent WIn id " + parentID);
		String childID = iterator.next();
		System.out.println("child win id " + childID);
		
		driver.switchTo().window(childID);
		List<WebElement> hyperlinks = driver.findElements(By.xpath("//a"));
		
		System.out.println("Total links in tabbed browser " + hyperlinks.size());
	
	//	driver.close();
		driver.switchTo().window(parentID);
		List<WebElement> hyperlinksOfParent = driver.findElements(By.xpath("//a"));
		
		System.out.println("Total links " + hyperlinksOfParent.size());
		
	}
	
	public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
	 
}