@dashboard
Feature: Dashboard Verification

  Background: Verify admin is able to land on home page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
    Then Admin enters valid credentials and clicks login button

  Scenario: Verify Logout button function
    Then Admin click Logout button on navigation bar
    Then Admin should land on the home page

  Scenario: Verify after login  admin lands on manage program as dashboard page
    Then Admin should see manage program as header

  Scenario: Verify after login  admin lands on manage program as dashboard page
    Then Admin should see manage program as header

  Scenario: Verify the response time
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  Scenario: Verify LMS title
    Then Admin should see LMS -Learning management system  as title

  Scenario Outline: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text for '<expectedField>'

    Examples: 
      | expectedField |
      | Program       |
      | Batch         |
      | User          |
      | Logout        |

  Scenario Outline: Validate correct order in navigation bar
    Then Admin should see correct <order> order in navigation bar text for '<expectedField>'

    Examples: 
      | expectedField | order |
      | Program       |     1 |
      | Batch         |     2 |
      | User          |     3 |
      | Logout        |     4 |

  Scenario Outline: Validate  field alignment in DashboardPage
    Then Admin should see '<fields>' is aligned as expected on navigation bar of DashboardPage

    Examples: 
      | fields  |
      | LMS     |
      | Program |
      | Batch   |
      | User    |
      | Logout  |
