@CreateCategory
Feature: Create a New Category with Valid Credentials
  As an admin
  I want to create a new category
  So that category was successfully created

  Scenario: As an admin I can create a new category with valid credentials
    Given I set API endpoint for create a new category
    When I send request endpoint for create a new category with valid credentials
    Then I receive status code 201 Created
    And I receive valid data for new category