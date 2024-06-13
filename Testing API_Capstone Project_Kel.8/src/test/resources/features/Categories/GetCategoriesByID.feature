@GetCategoriesByID
Feature: Get Category with Valid ID
  As an admin/user
  I want to get category with valid id
  So that I can receive 200 OK response and category information based on id

  Scenario: As an admin/user i want to get categories with valid id
    Given I set API endpoint with an valid ID to get category by valid ID
    When I send request endpoint for get category by valid ID
    Then I receive status code 200 OK response
    And I receive category information based on id