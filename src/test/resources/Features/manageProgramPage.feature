Feature: Manage Program Page Validation

  Scenario: logged LMS portal as admin status
    Given admin enters the LMS site
    When Admin enter <username> and <password>
    Then Admin suceessfully loggedin

  Scenario Outline: Validate elements in Program page
    Given Admin is on dashboard page after Login
    When Admin clicks Program link on the navigation bar
    Then Validate the Program page <elements>

    Examples: 
      | elements                                                  |
      #| Validate Manage program in url |
      | Validate Page title                                       |
      | Validate Pagination text is displayed                     |
      | Validate datatable footer text is displayed               |
      | Validate multiple program Delete Button is visible        |
      | Validate A New Program button is visible                  |
      #| Validate number of records per page is visible |
      | Validate Datatable Headers are visible                    |
      | Validate Sortable icon near datatable header is visible   |
      | Validate table checkbox are visible                       |
      | Validate editprogram and deleteprogram button are visible |
      | Validate Search box input is visible                      |
