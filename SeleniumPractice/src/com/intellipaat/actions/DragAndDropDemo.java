package com.intellipaat.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) {
		System.out.println("Main Started");
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameEle);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(draggable, droppable).build().perform();
		
		if(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText().equals("Dropped!")){
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		driver.switchTo().defaultContent();
		String headder = driver.findElement(By.xpath("//h1")).getText();
		System.out.println(headder);
		
		driver.close();
	}
}
