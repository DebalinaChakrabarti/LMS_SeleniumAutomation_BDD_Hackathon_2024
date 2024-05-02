Feature: Delete Program details

#	Background: Admin is on Manage Program Page after clicks Program on the navigation bar
#    Given Check if Admin is logged in for the Program Mdule
#    When Admin clicks on Program on the Navigation Bar to reach the Program module
#    Then Admin should be redirected to the Manage Program in the Program module
    
  Scenario: Delete Feature
    Given Admin is on Manage Program in the Program module
    When Admin clicks Delete button on the data table for any row in the Program module
    Then Admin should see a alert open with heading Confirm along with  YES and NO button for deletion in the Program module

  Scenario: Validate details for Confirm Deletion form
    Given Admin is on Manage Program in the Program module
    When Admin clicks on Delete button on the data table for any row in the Program module
    Then Admin should see a message "Are you sure you want to delete <Program name>?"
    
  Scenario: Click Yes on deletion window
    Given Admin is on Confirm Deletion alert popup in the Program module
    When Admin clicks YES button on the alert in the Program module
    Then Admin gets a message Successful Program Deleted alert and able to see that program deleted in the data table in the Program module

  Scenario: Click No on deletion window
    Given Admin is on Confirm Delete alert popup in the Program module
    When Admin clicks NO button on the alert in the Program module
    Then Admin can see the deletion alert disappears without deleting in the Program module

  Scenario: Validate Close X icon on Confirm Deletion alert in the Program module
    Given Admin is on Confirm Delete alert popup in the Program module
    When Admin clicks Close X Icon on Deletion alert in the Program module
    Then Admin can see the deletion alert disappears without any changes in the Program module
