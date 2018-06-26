package com.intellipaat.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/login.do");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.sendKeys("admin").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		act.sendKeys("manager").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		System.out.println("main ended....");
		WebElement usersTab = driver.findElement(By.xpath("//a[@class='content users']"));
		act.contextClick(usersTab).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.DOWN).perform();
		Thread.sleep(2000);
		//act.sendKeys(Keys.ENTER).perform();
		
		
	}
}
