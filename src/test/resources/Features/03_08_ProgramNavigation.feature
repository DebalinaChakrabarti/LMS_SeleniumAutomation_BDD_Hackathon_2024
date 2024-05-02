Feature: Navigation Validation from Manage Program to other Page

Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
    Given Check if Admin is logged in or not for the Program Mdule 
    When Admin clicks on "Program" on the Navigation Bar to reach the Program module
    Then Admin should be redirected to the Manage Program Page in the Program module

Scenario: Batch link on navigation bar
Given Admin is on Manage Program page in program module
When Admin clicks on Batch link on Manage Program page
Then Check if Admin is re-directed to Batch page

Scenario: User link on navigation bar
Given Admin is on Manage Program page in program module
When Admin clicks on User link on Manage Program page
Then Check if Admin is re-directed to User page

#Scenario: Logout link on navigation bar
#Given Admin is on Manage Program page in program module
#When Admin clicks on Logout link on Manage Program page
#Then Check if Admin is re-directed to Login page