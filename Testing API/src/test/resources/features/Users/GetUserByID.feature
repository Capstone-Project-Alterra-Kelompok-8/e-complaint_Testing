@GetUserByID
Feature: Get a User with valid ID
  As an admin/user
  I want to get user with valid id
  So That i can get 200 OK response detail user information by valid ID

  Scenario: As an admin/user i want to get user with valid id
    Given I set API endpoint for get user with valid id
    When I send request to get user information with valid ID
    Then I receive status code 200 OK response
    And I receive detail user information with valid ID