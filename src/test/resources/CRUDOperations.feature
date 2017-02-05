@Regression
@CRUDOperations
Feature: Perform CRUD operations

@CreateComputer 
Scenario Outline: Create computer 
	When I press the button "Add a new computer"
	And I enter <computerName> in the field "Computer name"
	And I enter <introducedDate> in the field "Introduced date"
	And I enter <discontinuedDate> in the field "Discontinued date"
	And I choose <company> from "Company" dropdown
	And I press the button "Create this computer"
	Then I see a message "Done! Computer <computerName> has been created"
	When I filter by <computerName>
	And I see <computerName> <introducedDate> <discontinuedDate> <company> in the table

Examples:
	|computerName   |introducedDate|discontinuedDate|company|
	|Computer Test 1|2017-02-04    |2018-03-14      |Sony   |

@ViewComputer 
Scenario Outline: View computer 
	When I filter by <computerName>
	Then I click on <computerName>
	And I see <computerName> in the field "Computer name"
	And I see <introducedDate> in the field "Introduced date"
	And I see <discontinuedDate> in the field "Discontinued date"
	And I choose <company> from "Company" dropdown
	And I press the button "Cancel"
	Then I can see the table with computers
Examples:
	|computerName   |introducedDate|discontinuedDate|company|
	|Computer Test 1|2017-02-04    |2018-03-14      |Sony   |

@EditComputer
Scenario Outline: Edit computer 
	When I filter by <computerOldName>
	Then I click on <computerOldName>
	And I enter <computerNewName> in the field "Computer name"
	And I enter <introducedDate> in the field "Introduced date"
	And I enter <discontinuedDate> in the field "Discontinued date"
	And I choose <company> from "Company" dropdown
	And I press the button "Save this computer"
	Then I see a message "Done! Computer <computerNewName> has been updated"
	When I filter by <computerNewName>
	And I see <computerNewName> <introducedDate> <discontinuedDate> <company> in the table
Examples:
	|computerOldName|computerNewName      |introducedDate    |discontinuedDate|company |
	|Computer Test 1|Computer Updated 1   |  2017-02-04      |                |IBM     |
	
@DeleteComputer
Scenario Outline: Delete computer 
	When I filter by <computerName>
	Then I click on <computerName>
	And I press the button "Delete this computer"
	Then I see a message "Done! Computer has been deleted"
	When I filter by <computerName>
	And I see a title message "No computers found"
Examples:
	|computerName      |
	|Computer Updated 1|	

