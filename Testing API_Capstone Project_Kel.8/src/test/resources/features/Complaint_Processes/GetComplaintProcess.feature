@GetComplaintProcess
Feature: Get Complaint Process with ID
  As an user
  I want to get complaint process with valid id
  So that I can receive 200 OK response and complaint process information based on id

  Scenario: As an user i want to get complaint process with valid id
    Given I set API endpoint with an valid ID to get complaint process by valid ID
    When I send request endpoint for get complaint process by ID
    Then I receive status code 200 OK response
    And I receive complaint process information based on id by valid ID

  Scenario: As an user i want to get complaint process with invalid id
    Given I set API endpoint with an valid ID to get complaint process by invalid ID
    When I send request endpoint for get complaint process by invalid ID
    Then I receive status code 404 not found
    And I receive response body that complaint process not found