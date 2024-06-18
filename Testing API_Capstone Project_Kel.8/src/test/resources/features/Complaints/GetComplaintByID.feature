@GetComplaintWithValidID
Feature: Get Complaint with ID
  As an admin
  I want to get admin with valid id
  So that I can receive 200 OK response and complaint information based on id

  Scenario: As an admin i want to get complaint with valid id
    Given I set API endpoint with an valid ID to get complaint by valid ID
    When I send request endpoint for get complaint by ID
    Then I receive status code 200 OK response
    And I receive complaint information based on id by valid ID

  Scenario: As an admin i want to get complaint with Invalid id
    Given I set API endpoint with an valid ID to get complaint by Invalid ID
    When I send request endpoint for get complaint by invalid ID
    Then I receive status code 404 not found
    And I receive response body that complaint not found