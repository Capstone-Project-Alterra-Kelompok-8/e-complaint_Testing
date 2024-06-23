@GetAdminWithValidID
Feature: Get Admin with Valid ID
  As an admin
  I want to get admin with valid id
  So that I can receive 200 OK response and admin information based on id

  Scenario: As an admin i want to get admin with valid id
    Given I set API endpoint with an valid ID to get admin by ID
    When I send request endpoint for get admin by ID
    Then I receive status code 200 OK response
    And I receive admin information based on id by ID