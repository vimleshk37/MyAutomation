Feature: BDD implementation using Cucumber

  @Login @Reg
  Scenario Outline: Login to OrangeHRM
    Given User is navigating to OrangeHRM Login Page
    When User need to enter username as <Username> and password as <Password>
    And Click on Submit Button
    Then Verify User is successfully navigated to the OrangeHRM Dashboard

    Examples: 
      | Username | Password    |
      | Admin    | admin123    |

      
    @Smoke
  Scenario Outline: Add New Employee to HRM Portal1
  	Given Navigate to PIM Page
    When Open Add Employee Tab
    And Fill Employee Information 
    Then Verify Employee added successfully navigated