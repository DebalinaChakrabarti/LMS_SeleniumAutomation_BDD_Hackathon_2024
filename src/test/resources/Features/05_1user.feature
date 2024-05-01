
  Feature: User page validation

Background: Admin is on dashboard page after Login 

Scenario: Validate url for UserPg
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see "user" on the page url

  Scenario Outline: Validate User page elements
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see <elements> on the page

    Examples:
      | elements                               |
      | a heading with text "Manage User"     |
      | the text as "Showing x to y of z entries" along with Pagination icon below the table |
      | cloumname Id is visible                               |
      | cloumname Name is visible                       |
      | cloumname Location is visible                        |
      | cloumname Phone Number is visible                    |
      | cloumname Edit/Delete is visible                     |
      | "+ Add New User" button above the data table           |
      | "+ Assign staff" button above the data table         |
      | "+ Assign Student" button above the data table       |
      | search text box above the data table                 |
      | records displayed on the data table              |
      | each row in the data table should have a checkbox    |
      | each row in the data table should have an enabled "edit icon"    |
      | each row in the data table should have an enabled "delete icon"  |
  
  
   Scenario: Search user by name
    Given Admin is on Mange user page
    When  When Admin enters valid user in Search box
    |Testing Squad|
    Then Admin should see user displayed with the entered name

  Scenario: Validating the Search with unrelated keyword
    Given Admin is on Mange user page 
    When  When Admin enters invalid user in Search box
    |MahaTeam|
    Then Admin should see zero entries on the data table
  