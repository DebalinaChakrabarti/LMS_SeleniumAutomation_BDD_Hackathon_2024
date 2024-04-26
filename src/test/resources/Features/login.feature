@tag
Feature: Home Page Verification

  Background: Verify admin is able to land on home page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page

  Scenario Outline: Validate login with valid credentials
    When Admin enters credentials '<Uname>' and '<Pwd>' and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | Uname                    | Pwd            |
      | sdetorganizers@gmail.com | UIHackathon@02 |
