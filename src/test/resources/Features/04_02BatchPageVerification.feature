@tag
Feature: Batch Page Validation

Background: Logged on the LMS portal

  @tag1
  Scenario: Validate landing in Batch page
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Admin should see the "Manage Batch" in the URL

  @tag2
  Scenario: Validate header in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Admin should see the 'Manage Batch' in the header

  @tag3
  Scenario: Validate pagination in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Admin should see the pagination controls under the data table

  @tag4
  Scenario: Validate data table headers in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Admin Should see the data table with headers Batch name, Batch Description etc

  @tag5
  Scenario: Validate Delete button in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Admin should be able to see the 'Delete' icon button that is disabled

  @tag6
  Scenario: Validate '+ A New batch' in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Admin should be able to see the '+ A New batch' button

  @tag7
  Scenario: Validate data rows for checkbox
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Each row in the data table should have a checkbox

  @tag8
  Scenario: Validate data rows for edit icon
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Each row in the data table should have a edit icon that is enabled

  @tag9
  Scenario: Validate data rows for delete icon
    Given Admin is on dashboard page after Login
    When Admin clicks 'Batch' from navigation bar
    Then Each row in the data table should have a delete icon that is enabled
    
  @tag10
  Scenario: Validate pop up for adding batch
    Given Admin is on dashboard page after Login
    When Admin clicks '+ A New Batch' button
    Then A new pop up with Batch details appears
    
    