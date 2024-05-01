Feature: Add New Program

  Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
    Given admin enters the LMS site
    When Admin enter <username> and <password>
    Then Admin suceessfully loggedin

  Scenario Outline: Validate elements in Program deatails modal are visible
    Given Admin is on Manage Program Page
    When Admin clicks A New Program button
    Then Validate Program details modal <elements>

    Examples: 
      | elements                                                       |
      | Validate buttons are visible                                   |
      | Validate all the input name and description fields are visible |
      | Validate status radio buttons are visible                      |

  Scenario: Empty form submission
    Given Admin is on Program Details modal window
    When Admin clicks Save button without entering any data
    Then Admin gets a Error message alert

  Scenario Outline: Enter only Program Name
    Given Admin is on Program Details modal window
    When Admin enters only Program Name "<Sheetname>" <Rownumber> in text box and clicks Save button
    Then Admin gets a message alert for Description and status field

    Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         0 |

  Scenario Outline: Enter only Program Description
    Given Admin is on Program Details modal window
    When Admin enters only Program Description "<Sheetname>" <Rownumber>  in text box and clicks Save button
    Then Admin gets a message alert for program name and status field

    Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         0 |

  Scenario Outline: Select Status only
    Given Admin is on Program Details modal window
    When Admin selects only Status "<Sheetname>" <Rownumber>  and clicks Save button
    Then Admin gets a message alert program Name and Description field

    Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         0 |
      | Manage Program |         1 |

  Scenario Outline: Validate invalid values on the text column
    Given Admin is on Program Details modal window
    When Admin enters only numbers or special char in Pgm name and Desc "<Sheetname>" <Rownumber> column
    Then Admin gets a Error message alert for invalid inputs

    Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         2 |
      | Manage Program |         3 |
      | Manage Program |         4 |

  Scenario: Validate Cancel or Close X icon on Program Details form
    Given Admin is on Program Details modal window
    When Admin clicks Cancel or Close X Icon on Program Details form
    Then Program Details popup window should be closed without saving

  Scenario Outline: Validate Save button on Program Details form
    Given Admin is on Program Details modal window
    When Enter all the required name and description and status "<Sheetname>" <Rownumber> with valid values and click Save button
    Then Admin gets a message Successful Program Created alert and able to see the new program added in the data table

   Examples: 
      | Sheetname      | Rownumber |
      | Manage Program |         0 |
      | Manage Program |         1 |
