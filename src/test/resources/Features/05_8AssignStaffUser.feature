Feature: Assign Staff 

Background: Admin is on Manage User Page after clicks User on the navigation bar

Scenario: Validate Assign Staff Popup window
    Given Admin is on User Page
    When Admin clicks on "Assign Staff" button
    Then User should see a pop up open for assign staff with empty form along with Save and Cancel button and close icon on the top 
    
 #Scenario Outline:: Validate input fields and their text boxes in Assign staff form 
    #Given Admin is on Manage User Page
    #When Admin clicks "Assign Staff" button
    #Then Admin should see below input "<Fields>" on the form
  #Examples: 
    #|Fields|
    #|User Role|
    #|Staff Email id|
    #|Skill|
    #|Program Name|
    #|Batch Name|
    #|Status|
    #
#Scenario Outline: Validate the Assign Staff form page without entering data in mandatory field
    #Given Admin is in "Assign Staff" details pop up page
    #When Admin enter data from excel "<SheetName>" <RowNumber> and clicks "Save" button.
    #Then Admin gets a Error message alert
 #Examples: 
      #| Sheetname  | RowNumber |
      #| User       |         0 |
      
#Scenario: Empty Form Submission
    #Given Admin is on "Assign Staff" details pop up page
    #When Admin clicks "Save" button without entering any data
    #Then Admin gets a Error message alert
   #
#Scenario: Validate radio button in Assign Staff Form
    #Given Admin is in manage user page
    #When Admin clicks "Assign Staff" button
    #Then Admin should see two radio buttons for Status and only one button should be seleted at time 
