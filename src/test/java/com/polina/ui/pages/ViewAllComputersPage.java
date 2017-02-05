package com.polina.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewAllComputersPage extends AbstractPage {
	
	
	public ViewAllComputersPage(WebDriver driver) {
		super(driver);
		
	}
	
	/**
	 * Filters by computer 
	 * @param computer
	 */
	public void filtersComputer(String computer){
		getElement(By.id("searchbox")).sendKeys(computer);
		pressButton("Filter by name");
	}
	
	/**
	 * 
	 * @return The text of the create/edit/delete text
	 */
	public String getMessageText(){
		return getElement(By.cssSelector("div[class='alert-message warning']")).getText();
	}
	
	/**
	 * 
	 * @return The text of the create/edit/delete text
	 */
	public String getTitleMessageText(){
		return getElement(By.cssSelector("section[id='main']>h1")).getText();
	}
	
	/**
	 * 
	 * @return the text of a table row
	 */
	public String getTableRowText(){
		 return getElement(By.cssSelector("table[class='computers zebra-striped']>tbody>tr")).getText();
	}
	
	/**
	 * Click on a computer
	 * @param computer Name of computer
	 */
	public void clickOnAComputer(String computer){
		getElement(By.linkText(computer)).click();
	}
	
	/**
	 * 
	 * @return text containing the header of the table
	 */
	public String getTableHeaderText(){
		return getElement(By.cssSelector("table[class='computers zebra-striped']>thead>tr")).getText();
		
	}
	
	/**
	 * 
	 * @page Page to click
	 */
	public void clickOnPage(String page){
		if(page.equals("Next")){
			getElement(By.cssSelector("li[class='next']>a")).click();;
		}else{
			getElement(By.cssSelector("li[class='prev']>a")).click();;
		}
	}
	
	/**
	 * 
	 * @return number of rows
	 */
	public int getTableRows(){
		return driver.findElements(By.cssSelector("table[class='computers zebra-striped']>tbody>tr")).size();
	}
	
	/**
	 * 
	 * @return text in Pagiation
	 */
	public String getPaginationText(){
		return getElement(By.id("pagination")).getText();
	}
}
