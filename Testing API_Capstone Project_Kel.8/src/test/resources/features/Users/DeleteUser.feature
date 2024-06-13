@DeleteUser
Feature: Delete User with Valid ID
  As an Admin
  I want to delete user by valid ID
  So that the user account can be removed

  Scenario: As an Admin I can delete user with valid ID
    Given I set API endpoint for delete user with valid ID
    When I send request endpoint for delete user
    Then I receive status code 200 OK response
    And I receive response body for delete user