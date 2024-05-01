Feature: Add New Batch

Background: Logged on the LMS portal

  @tag1
  Scenario Outline: Check if the fields exist in pop
    Given A new pop up with Batch details appears
    Then The pop up should include these <elements>

    Examples: 
      | elements  |
      | Batch Name |
      | Description |
      | Program Name |
      | Status |
      | No of Classes |
      
  @tag2
  Scenario: Check if description is optional field
    Given A new pop up with Batch details appears
    When Fill in all the fields except description
    Then The newly added batch should be present in the data table

  @tag3
  Scenario: Check if the program details are added in data table
    Given A new pop up with Batch details appears
    When Fill in all the fields with valid values and click save
    Then The newly added batch should be present in the data table

  @tag4
  Scenario: Check for error messages for invalid fields
    Given A new pop up with Batch details appear
    When any of the fields have invalid values
    Then Error message should appear

  @tag5
  Scenario: Check for error messages for mandatory fields
    Given A new pop up with Batch details appear
    When Any of the mandatory fields are blank
    Then Error message should appear
      