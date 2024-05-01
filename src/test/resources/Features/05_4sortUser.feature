Feature: Sorting User Details on Manage User Page

Background: Admin is on dashboard page after Login and clicks User on the navigation bar

  Scenario: Admin sorts User details by ID
    Given Admin is on Manage User Page
    When Admin clicks on ID sort icon
    Then Admin should see User details are sorted by ID

  Scenario: Admin sorts User details by Name
    Given Admin is on Manage User Page
    When Admin clicks on name sort icon
    Then Admin should see User details are sorted by Name

  Scenario: Admin sorts User details by Location
    Given Admin is on Manage User Page
    When Admin clicks on Location sort icon
    Then Admin should see User details are sorted by Location

  Scenario: Admin sorts User details by Phone number
    Given Admin is on Manage User Page
    When Admin clicks on Phone number sort icon
    Then Admin should see User details are sorted by Phone number
