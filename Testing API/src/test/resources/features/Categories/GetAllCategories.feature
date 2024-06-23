@GetAllCategories
Feature: Get All Categories
  As an admin/user
  I want to get all categories details
  So That i can get 200 OK response and data for all categories

  Scenario: As an admin/user i want to get all categories
    Given I set API endpoint for get all categories
    When I send request endpoint for get all categories
    Then I receive status code 200 OK response
    And I receive data for all categories details