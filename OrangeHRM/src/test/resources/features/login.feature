Feature: Login functionality

  Scenario: Login with valid credentials
    Given User is on login page
    When User enters valid username
    And User enters valid password
    And User clicks login button
    Then User should navigate to dashboard page

  Scenario: Login with invalid credentials
    Given User is on login page
    When User enters invalid username
    And User enters invalid password
    And User clicks login button
    Then Error message should be displayed
