@user
Feature: User Details Popup Validation

Background: Admin is on dashboard page after Login and clicks User on the navigation bar


Scenario Outline: Validate User Details Popup window
    Given Admin is on Manage User Page
    When Admin should click "+ A New User" 
    Then Admin should see a pop-up open for user details with the following <fields>
         |fields|
        | First Name      |
        | Middle Name     |
        | Last Name       |
        | Location        |
        | Phone           |
        | Email           |
        | LinkedIn URL    |
        | User Role       |
        | Role Status     |
        | Visa Status     |
        | Undergraduate   |
        | Postgraduate    |
        | Time Zone       |
        | User Comments   |
        |Cancel            |
        |Submit|
        |Close|
        
Scenario Outline: Validate input fields and text boxes in user details form
    
    When Admin is on the User details pop-up
    Then Admin should see text boxes for the <names>
        |names|
        | First Name    |
        | Middle Name   |
        | Last Name     |
        | Location      |
        | Phone         |
        | Email         |
        | LinkedIn URL  |
        | Undergraduate |
        | Postgraduate  |
        | Time Zone     |
        | User Comments |

Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on the User details pop-up
    When Admin enters mandatory fields in the form and clicks on the submit button from  "<Sheetname>" <RowNumber>
    Then Admin gets a message "User Added Successfully"
    Examples:
     | Sheetname  | RowNumber |
     | User        |   0       |
     
Scenario Outline: Check if user is created when only optional fields are entered with valid data
    #Given Admin clicks "+ A New User" button
        Given Admin should click "+ A New User" 
    
    When Admin skips mandatory fields in the form and clicks on the submit button from  "<Sheetname>" <RowNumber>
    Then Admin should see an error message below the fields and the fields will be highlighted in red color
     Examples:
     | Sheetname  | RowNumber |
     | User        |   1     |
     
       
    Scenario Outline: Check if user is created when invalid data is entered in all of the fields
    #Given Admin clicks "+ A New User" button
    Given Admin should click "+ A New User"     
    When Admin enters invalid data in all of the fields in the form and clicks on the submit button from "<Sheetname>" <RowNumber>
    Then Admin gets an error message and user is not created
    Examples:
     | Sheetname  | RowNumber |
     | User        |   2     |
     
   Scenario: Empty form submission
    #Given Admin clicks "+ A New User" button
    Given Admin should click "+ A New User"     
    When Admin clicks on the submit button without entering data
    Then user wont be created and Admin gets an error message

Scenario: Validate Cancel/Close(X) icon on User Details form
    #Given Admin clicks "+ A New User" button
    Given Admin should click "+ A New User"     
    When Admin clicks Close Icon on User Details form
    Then User Details popup window should be closed without saving

Scenario: Validate Cancel button on User Details form
    #Given Admin clicks "+ A New User" button
    Given Admin should click "+ A New User" 
    When Admin clicks Cancel button
    Then User Details popup window should be closed without saving

Scenario Outline: Check if the user details are added in data table
      #Given Admin clicks "+ A New User" button
    Given Admin should click "+ A New User" 
    When Admin fills in all the fields with valid values and clicks submit from "<Sheetname>" <RowNumber>
    Then the newly added user should be present in the data table in Manage User page
Examples:
     | Sheetname  | RowNumber |
     | User        |   3      |
