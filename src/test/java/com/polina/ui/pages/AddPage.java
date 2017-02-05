package com.polina.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddPage extends AbstractPage{
	
	public AddPage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement getField(String fieldName){
		WebElement field = null;
		switch(fieldName){
			case "Computer name":
				field = getElement(By.id("name"));
			break;
			case "Introduced date":
				field = getElement(By.id("introduced"));
				break;
			case "Discontinued date":
				field = getElement(By.id("discontinued"));
				break;	
		}
		return field;
	}
	
	/**
	 * Types text in a field
	 * @param fieldName the Name of the field
	 */
	public void TypeText(String fieldName, String text){
		getField(fieldName).clear();
		getField(fieldName).sendKeys(text);
	}
	
	/**
	 * Types text in a field
	 * @param fieldName the Name of the field
	 */
	public String getValue(String fieldName){
		return getField(fieldName).getAttribute("value");
	}
	
	/**
	 * Selects a company
	 * @param company
	 */
	public void selectCompany(String company){
		new Select(getElement(By.id("company"))).selectByVisibleText(company);
	}
	
	/**
	 * 
	 * @return true if there is a Required Error Message
	 */
	public boolean errorMessageExist(){
		if( driver.findElements(By.cssSelector("div[class='clearfix error']")).size() > 0){
			return true;
		}
		else{
			return false;
		}	
	}
}
