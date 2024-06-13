@GetAllUser
Feature: Get All Users
  As an admin
  I want to get all users
  So That i can get 200 OK response

  Scenario: As an admin i want to get all users
    Given I set API endpoint for get all users
    When I send request to get all users
    Then I receive status code 200 OK response
    And I receive all of users