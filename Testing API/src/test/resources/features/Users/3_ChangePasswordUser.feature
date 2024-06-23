@ChangePasswordUser
Feature: Change Password User with valid credentials
  As an user
  I want to change my password user
  So that my user password was successfully changed

  Scenario: As an User I want to change my password user with valid credentials
    Given I set API endpoint for change password user
    When I send request endpoint for change password user with valid credentials
    Then I receive status code 200 OK response
    And I receive response body for my user password was successfully changed