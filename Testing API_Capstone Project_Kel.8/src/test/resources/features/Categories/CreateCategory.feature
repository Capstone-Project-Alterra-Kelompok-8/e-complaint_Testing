@CreateCategory
Feature: Create a New Category
  As an admin
  I want to create a new category
  So that category was successfully created

  Background:
    Given I set API endpoint for create a new category

  Scenario: As an admin I can create a new category with valid credentials
    When I send request endpoint for create a new category with valid credentials
    Then I receive status code 201 Created
    And I receive valid data for new category

    #Negative
  Scenario: As an admin I can to create a new category by leaving one of the fields blank
    When I sent the endpoint a request to create a new category by leaving one of the fields blank
    Then I receive status code 400 Bad Request
    And I received an error message that all fields must be filled in