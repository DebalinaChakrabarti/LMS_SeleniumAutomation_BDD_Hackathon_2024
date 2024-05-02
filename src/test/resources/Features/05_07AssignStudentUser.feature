#Feature: Assign Student
#
#Background: Admin is on Manage User Page after clicks User on the navigation bar

#Scenario: Validate Assign Student Popup window
    #Given Admin is on Manage User Page
    #When Admin clicks "Assign Student" button
    #Then Admin should see a pop up open with empty form along with Save and Cancel button and close icon 
 
 
 
 
#Scenario Outline: Validate input fields and their text boxes in Assign Student form 
    #Given Admin is on Manage User Page
    #When Admin clicks "Assign Student" button
    #Then Admin is able to see user role as R03 and below input "<Fields>" on form
#Examples:
    #|Fields|
    #|User Role|
    #|Student Email id|
    #|Program Name|
    #|Batch Name|
    #|Status|
    #
    
#@10 AssignStudent
#Scenario Outline: Validate the Assign Student form page without entering data in manadatory fields
    #Given Admin is in "Assign Student" details pop up page
    #When Admin clicks "Save" button after entering data "<Sheetname>" and <RowNumber> from excel.
    #Then Admin gets a Error message
#Examples: 
      #| Sheetname  | RowNumber |
      #| User       |         0 | 
    #
#
#@11 AssignStudent
#Scenario: Empty Form Submission
    #Given Admin is on "Assign Student" details pop up page
    #When Admin clicks "Save" button without entering any data
    #Then Admin should see an error message below the fields and highlighted in red color
   #
#@12 AssignStudent
#Scenario: Validate radio button in Assign Student Form
    #Given Admin is in manage user page
    #When Admin clicks "Assign Student" button
    #Then Admin should see two radio buttons for Status and only one button should be seleted at time 
#
#@13 AssignStudent
#Scenario: Validate Cancel and Close icon on Assign Student form
     #Given Admin is on "Assign Student" details pop up page
     #When Admin clicks Cancel or Close icon on Assign Student form
     #Then Assign Student popup window should be closed without saving
   #
    #
     