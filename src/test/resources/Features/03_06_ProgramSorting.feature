@tag
 Feature: Sorting Validation


	Background: Admin is on Manage Program Page after clicks Program on the navigation bar
	    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
    Then Admin enters valid credentials and clicks login button
    Given Check if Admin is logged in or not for the Program Mdule
    When Admin clicks on "Program" on the Navigation Bar to reach the Program module
    Then Admin should be redirected to the Manage Program Page in the Program module

  @TC_Validates_Sorting
  Scenario: Validates Sorting(data ordering) on the Program Data table
    Given Admin is on Manage Program page in the Program module
    When Admin clicks the sort icon of program name column in the Program module
    Then The data get sorted on the table based on the program name column values in ascending order in the Program module

    Given The data is in the ascending order on the table based on Program Name column in the Program module
    When Admin clicks the sort icon of program name column to sort Program name in descending order in the Program module
    Then The data get sorted on the table based on the program name column values in descending order in the Program module
 
    Given Admin is on Manage Program page in the Program module
    When Admin clicks the sort icon of program Desc column in the Program module
    Then The data get sorted on the table based on the program description column values in ascending order in the Program module

    Given The data is in the ascending order on the table based on Program Description column in the Program module
    When Admin clicks the sort icon of program Desc column to sort Program description in descending order in the Program module
    Then The data get sorted on the table based on the program description column values in descending order in the Program module

    Given Admin is on Manage Program page in the Program module
    When Admin clicks the sort icon of program Status column in the Program module
    Then The data get sorted on the table based on the program status column values in ascending order in the Program module
    
    Given The data is in the ascending order on the table based on Program Status column in the Program module
    When Admin clicks the sort icon of program Status column to sort Program status in descending order in the Program module
    Then The data get sorted on the table based on the program status column values in descending order in the Program module



