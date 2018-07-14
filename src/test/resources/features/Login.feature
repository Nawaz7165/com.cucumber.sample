@regression @login
Feature: Login feature


  Background:
    Given User is on the Threely login page

  @login-1
  Scenario: Verify valid login
    When  I enter username as mdrahman.techno@gmail.com and password as password
    And   I click on submit button
    Then  I verify logout button is displayed