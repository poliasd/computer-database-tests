package com.polina.ui.tests.steps;

import com.polina.ui.tests.BaseTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class StepsDefinitions extends BaseTest {
	
	@Before
	public void setup() {
		openApp();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

	@And("I enter (.*) in the field \"(.*)\"")
	public void iEnterComputerIntheFiledComputerName(String text, String field) {
		addPage.TypeText(field, text);
	}

	@And("I choose (.*) from \"Company\" dropdown")
	public void ichooseFromCompanyDropdown(String company) {
		addPage.selectCompany(company);
	}

	@When("I press the button \"(.*)\"")
	public void iPressTheButton(String button) {
		addPage.pressButton(button);
	}

	@Then("I see a message \"(.*)\"")
	public void iCanSeeMessage(String message) {
		Assert.assertEquals("Message is not as expected.", message,
				viewPage.getMessageText());
	}

	@When("I filter by (.*)")
	public void iFilterBy(String computer) {
		viewPage.filtersComputer(computer);
	}

	@And("I see (.*) (.*) (.*) (.*) in the table")
	public void iSeeInTheTable(String computerName, String introducedDate, String discontinuedDate, String company) {
		
		String expectedRow = viewPage.getTableRowText();
		Assert.assertTrue("Computer Name "+ computerName + " not found in table row: " + expectedRow, expectedRow.contains(computerName));
		Assert.assertTrue("Introduced Date " + formatToTableDate(introducedDate) + " not found in table row: " + expectedRow,
				expectedRow.contains(formatToTableDate(introducedDate)));
		Assert.assertTrue("Discontinued Date "+ formatToTableDate(discontinuedDate) + " not found in table row: " + expectedRow,
				expectedRow.contains(formatToTableDate(discontinuedDate)));
		Assert.assertTrue("Company " + company + " not found in table row: " + expectedRow, expectedRow.contains(company));
	}

	@Then("I click on (.*)")
	public void iClickOn(String computer) {
		viewPage.clickOnAComputer(computer);
	}

	@And("I see (.*) in the field \"(.*)\"")
	public void iSeeInTheField(String data, String field) {
		Assert.assertEquals("Expected field is not as expected", data, addPage.getValue(field));
	}

	@Then("I can see the table with computers")
	public void iCanSeeTheTableWithComputers() {
		Assert.assertTrue("Table with computers cannot be seen.", viewPage.getTableHeaderText().contains("Computer name"));
	}
	
	@And("I see a title message \"(.*)\"")
	public void iSeeTitleMessage(String message){
		Assert.assertEquals("Message is not as expected.", message,	viewPage.getTitleMessageText());
	}
	
	@Then("I see an error message") 
	public void iSeeErrordMessage(){
		Assert.assertTrue("An error message is not shown.", addPage.errorMessageExist());
	}
	
	@When("I click \"(.*)\" page")
	public void iClickOnPagination(String page){
		viewPage.clickOnPage(page);
	}
	
	@Then("I see 10 computers in the table")
	public void iSee10ComputersInTheTable(){
		Assert.assertEquals(10, viewPage.getTableRows());
	}
	
	@And("I see pagination text \"(.*)\"")
	public void iSeePaginationText(String text){
		Assert.assertTrue("The text in pagination is not as expected.", viewPage.getPaginationText().contains(text));
	}
}
