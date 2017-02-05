package com.polina.ui.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.polina.ui.pages.AddPage;
import com.polina.ui.pages.ViewAllComputersPage;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	protected AddPage addPage;
	protected ViewAllComputersPage viewPage;
	
	protected void openApp(){
	//	System.setProperty("webdriver.chrome.driver", "C:\\chrome-driver\\chromedriver.exe");
		if(System.getProperty("BROWSER").equals("firefox")){
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		} else if (System.getProperty("BROWSER").equals("chrome")){
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver(); 
		}
		
		driver.get(System.getProperty("APP_URL"));
		driver.manage().window().maximize();
		addPage = new AddPage(driver);
		viewPage = new ViewAllComputersPage(driver);
	}
	
	
	/**
	 * 
	 * @param date Date that will be formatted
	 * @return the date in format in expected by the table with results
	 */
	protected String formatToTableDate(String date){
		String expectedDate = "-";
		if(!date.equals("")){
			DateTimeFormatter originalFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter exectedFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
			
			LocalDate introducedFormatDate = LocalDate.parse(date, originalFormat);
			expectedDate = introducedFormatDate.format(exectedFormat);
		}
		
		return expectedDate;
	}
}
