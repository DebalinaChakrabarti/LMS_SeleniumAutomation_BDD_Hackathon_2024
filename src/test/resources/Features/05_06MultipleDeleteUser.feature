Feature: Delete Multiple Users

  @tag1
  Scenario: Validate the delete icon below the header 
    Given None of the checkboxes in data table are selected
    Then The delete icon under the 'Manage User' header should be disabled

  @tag2
  Scenario: Check for single row delete
    Given One checkbox is selected
    When Click delete below Manage User header
    Then The respective row in the table is deleted

  @tag3
  Scenario: Check for multi row delete
    Given Two or more checkboxes are selected in the user data table
    When Click del button below Manage User header
    Then The respective row in the table is deleted

