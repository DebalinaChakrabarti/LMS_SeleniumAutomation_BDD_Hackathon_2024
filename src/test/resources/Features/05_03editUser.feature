Feature: Update User Details

Background: Admin is on dashboard page after Login and clicks User on the navigation bar

  Scenario: Validate row level edit icon 
    Given Admin is on Manage User Page
    When Admin clicks on the edit icon
    Then A new pop up with User details appears
    
    Scenario Outline: Update User Details
    Given Admin is on User details pop up
    When Admin updates user form with <validity> values and submits from "<SheetName>" <RowNumber>
    Then <outcome> is displayed

    Examples:
    | SheetName | RowNumber | validity          | outcome                      |
    | User      | 4         | valid             | User updated Successfully    |
    | User      | 5         | invalid           | Error message is received    |
   
    
 