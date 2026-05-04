Feature: Login

  Background:
    Given User is on Home page
    When User clicks "Log in"
    Then the login tab appears

  @validCredentials @Smoke
  Scenario: Login with valid credentials
    
    When User enters uername as "Admin"
    And User enters password as "admin"
    And User clicks "Login Button"
    Then User should be able to login successfully
    And the home need to be appeared with the confirmation message "Welcome Admin"

  @invalidUsername @Regression
  Scenario: Login with invalid username
    
    When User enters uername as "Adminhlop"
    And User enters password as "admin123"
    And User clicks "Login Button"
    Then the pop with the message "User does not exist." must be appear
    And User should not be logged in to homepage

  @invalidPassword
  Scenario: Login with invalid password
    
    When User enters uername as "Admin"
    And User enters password as "admin123hop"
    And User clicks "Login Button"
    Then the pop with the message "Wrong password." must be appear
    And User should not be logged in to homepage