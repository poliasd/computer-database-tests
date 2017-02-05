package com.polina.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * 
	 * Waits for an element to be loaded
	 * @param seleniumElement - Selenium Element
	 * @return Web Element
	 */
	protected WebElement getElement(By seleniumElement){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(seleniumElement));
		return driver.findElement(seleniumElement);
	}
	
	/**
	 * Press a button
	 * @param name The name of the button
	 */
	public void pressButton(String name){
		switch(name){
			case "Add a new computer":
				getElement(By.id("add")).click();;
			break;
			case "Create this computer":
				getElement(By.cssSelector("input[class='btn primary']")).click();;
			break;
			case "Cancel":
				getElement(By.linkText("Cancel")).click();;
			break;
			case "Save this computer":
				getElement(By.cssSelector("input[class='btn primary']")).click();;
			break;
			case "Delete this computer":
				getElement(By.cssSelector("input[class='btn danger']")).click();;
			break;
			case "Filter by name":
				getElement(By.id("searchsubmit")).click();;
			break;
		}
	}
	
	
}
