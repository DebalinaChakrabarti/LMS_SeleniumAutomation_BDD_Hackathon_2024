Feature: Update Program Details

  Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
  	    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
    Then Admin enters valid credentials and clicks login button
     #Given Admin is on Dashboard page after login for Manage Program
    #When Clicks Program page
    #Then Validate Admin is on Program window for edit
    
  Scenario: Validate Edit Feature
    Given Admin is on Manage Program Page for edit
    When Admin clicks Edit icon on the data table for any row
    Then Admin should see a modal open for Program details to edit

  Scenario Outline: Update Program Name
    Given Admin is on Program Details modal window to Edit
    When Admin updates the program name "<Sheetname>" <Rownumber> field and clicks save button
    Then Admin gets a message Successful Program Updated alert and able to see the updated name in the table for the particular program

    Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         5 |

  Scenario Outline: Update Program description
    Given Admin is on Program Details modal window to Edit
    When Admin updates the Description "<Sheetname>" <Rownumber>  field and clicks save button
    Then Admin gets a message Successful Program Updated alert and able to see the updated description in the table for the particular program

    Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         5 |

  Scenario Outline: Update Program Status
    Given Admin is on Program Details modal window to Edit
    When Admin updates the Status "<Sheetname>" <Rownumber>  and clicks save button
    Then Admin gets a message Successful Program Updated alert and able to see the updated status in the table for the particular program

    Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         5 |

  Scenario Outline: Validate invalid values on the text fields
    Given Admin is on Program Details modal window to Edit
    When Admin enters only numbers or special char in name and description field "<Sheetname>" <Rownumber> 
    Then Admin gets a Error message alert invalid details to update
    
    Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         2 |
      | Manage Program |         3 |
      | Manage Program |         4 |

  Scenario: Validate Cancel button on Edit modal
    Given Admin is on Program Details modal window to Edit
    When Admin clicks Cancel button on edit modal
    Then Admin can see the Program details modal disappears and can see nothing changed for particular program
