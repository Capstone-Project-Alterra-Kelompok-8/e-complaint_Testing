@GetAllRegencies
Feature: Get All Regencies
  As an user
  I want to get all regencies
  So That i can get 200 OK response

  Scenario: As an user i want to get all regencies
    Given I set users API endpoint for get all regencies
    When I send GET request to get all regencies
    Then I receive status code 200 OK response
    And I receive all of regencies