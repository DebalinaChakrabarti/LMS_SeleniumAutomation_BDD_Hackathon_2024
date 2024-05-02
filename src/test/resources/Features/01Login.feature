
Feature: Home Page Verification

  Background: Verify admin is able to land on home page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page

  Scenario: Validate logo is displayed in loginPage
    Then Admin should see expected logo image in login page

  Scenario: Validate field allignments in loginPage
    Then Admin should see input and loginbutton are in center of login page

  Scenario: Validate Page Not found
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve 404 page not found error

  Scenario Outline: Validate login with valid credentials
    When Admin enters credentials '<Uname>' and '<Pwd>' and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | Uname                    | Pwd            |
      | sdetorganizers@gmail.com | UIHackathon@02 |

  Scenario Outline: Validate login page elements and invalid credentials
    When Admin enters credentials '<Uname>' and '<Pwd>' and clicks login button
    Then Admin should see the Error message please check expected '<msg>' displays

    Examples: 
      | Uname                    | Uname          | msg                                            |
      | sdetorganizers@gmail.co  | UIHackathon@02 | Invalid username and password Please try again |
      | sdetorganizers@gmail.com | UIHackathon@   | Invalid username and password Please try again |
      | ""                       | UIHackathon@02 | Please enter your username                     |
      | sdetorganizers@gmail.com | ""             | Please enter your password                     |

  Scenario Outline: Validate login with valid credentials by clicking Login button through Keypad
    When Admin enters credentials '<Uname>' and '<Pwd>' and clicks login button through keypad
    Then Admin should land on dashboard page

    Examples: 
      | Uname                    | Pwd            |
      | sdetorganizers@gmail.com | UIHackathon@02 |

  Scenario Outline: Validate Fields are displayed in LoginPage
    When Admin should see '<expectedField>'

    Examples: 
      | expectedField                   |
      | Please login to LMS application |
      | username                        |
      | password                        |
      | userfieldlabel                  |
      | passwordfieldlabel              |
      | login                           |
      | logBtnlabel                     |

  Scenario Outline: Validate loginpage color
    When Admin should see user in '<expectedField>' color

    Examples: 
      | expectedField |
      | usercolor     |
      | passwordcolor |
