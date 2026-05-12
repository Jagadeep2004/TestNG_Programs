Feature: PIM Functionality

  Scenario Outline: Add Multiple Employees
    Given User is logged into OrangeHRM
    When User clicks PIM module
    And User clicks Add Employee
    And User enters firstname "<firstname>"
    And User enters middlename "<middlename>"
    And User enters lastname "<lastname>"
    And User clicks Save button
    Then Employee should be added successfully

    Examples:
      | firstname | middlename | lastname |
      | John      | A          | David    |
      | Robert    | B          | James    |
      | Arjun     | C          | Kumar    |
      | Rahul     | D          | Sharma   |

  Scenario: Search Employee
    Given User is logged into OrangeHRM
    When User clicks PIM module
    And User enters employee name in search box
    And User clicks Search button
    Then Employee details should be displayed

  Scenario: Search Invalid Employee
    Given User is logged into OrangeHRM
    When User clicks PIM module
    And User enters invalid employee name
    And User clicks Search button
    Then No records found message should be displayed
