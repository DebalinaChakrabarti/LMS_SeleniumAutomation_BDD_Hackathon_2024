Feature: Manage Program Page Validation
#
  #Scenario: logged LMS portal as admin status
    #Given admin enters the LMS site
    #When Admin enter <username> and <password>
    #Then Admin suceessfully loggedin
    
      #Background: Verify admin is able to land on home page
    #When Admin gives the correct LMS portal URL
    #Then Admin should land on the home page
    #Then Admin enters valid credentials and clicks login button

  Scenario Outline: Validate elements in Program page
    Given Admin is on Dashboard page after login for Manage Program
    When Admin has clicked Program link on the navigation bar
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
