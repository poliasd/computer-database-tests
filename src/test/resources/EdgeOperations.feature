@Regression
@EdgeOperations
Feature: Perform Edge operations

@CreateEmptyComputerName
Scenario Outline: Create a computer with an empty name
	When I press the button "Add a new computer"
	And I enter <computerName> in the field "Computer name"
	And I enter <introducedDate> in the field "Introduced date"
	And I enter <discontinuedDate> in the field "Discontinued date"
	And I choose <company> from "Company" dropdown
	And I press the button "Create this computer"
	Then I see an error message 
Examples:
	|computerName   |introducedDate|discontinuedDate|company|
	| 				|2017-02-11    |			    |RCA    |

@CreateInvalidDates
Scenario Outline: Create a computer with an invalid date
	When I press the button "Add a new computer"
	And I enter <computerName> in the field "Computer name"
	And I enter <introducedDate> in the field "Introduced date"
	And I enter <discontinuedDate> in the field "Discontinued date"
	And I choose <company> from "Company" dropdown
	And I press the button "Create this computer"
	Then I see an error message 
Examples:
	|computerName   |introducedDate|discontinuedDate|company  |
	|InvalidDate    |2017-02-45    |2017-02-11      |Netronics|	
	|InvalidDate    |xxxxxxxxxx    |2017-02-11      |Netronics|
	|InvalidDate    |              |2019-62-11      |Netronics|
	|InvalidDate    |2017-12-01    |2017            |Netronics|
	
@UpdateEmptyComputerName
Scenario Outline: Edit a computer with an empty name
	When I filter by <computerName>
	Then I click on <computerName>
	And I enter <computerNewName> in the field "Computer name"
	And I press the button "Save this computer"
	Then I see an error message 
Examples:
	|computerName   |computerNewName|
	|Amiga 			|				|

@UpdateInvalidDates
Scenario Outline: Edit a computer with an empty name
	When I filter by <computerName>
	Then I click on <computerName>
	And I enter <introducedDate> in the field "Introduced date"
	And I enter <discontinuedDate> in the field "Discontinued date"
	And I press the button "Save this computer"
	Then I see an error message 
Examples:
	|computerName   |introducedDate|discontinuedDate|
	|Amiga          |2017-02-45    |2017-02-11      |
	|Amiga          |xxxxxxxxxx    |2017-02-11      |
	|Amiga          |              |2019-62-11      |
	|Amiga          |2017-12-01    |2017            |
	
@CheckNextPage
Scenario: Checks next Computers
	When I click "Next" page
	Then I see 10 computers in the table
	And I see pagination text "Displaying 11 to 20" 
	When I click "Previous" page
	Then I see 10 computers in the table
	And I see pagination text "Displaying 1 to 10" 
