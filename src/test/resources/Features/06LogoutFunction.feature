
Feature: Logout Functionality


  Background: Verify admin is able to land on home page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
    Then Admin enters valid credentials and clicks login button

  Scenario: Verify Logout button function
    Then Admin click Logout button on navigation bar
    Then Admin should land on the home page
