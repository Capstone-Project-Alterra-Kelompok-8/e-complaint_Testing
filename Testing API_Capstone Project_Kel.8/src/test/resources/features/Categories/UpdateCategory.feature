@UpdateCategory
Feature: Update Category
  As an admin
  I want to update category
  So that I can update information for specific category

  Background:
    Given I set API endpoint for update category

  Scenario: As an admin i can update category with valid credentials
    When I send request to update category with valid credentials
    Then I receive status code 200 OK response
    And I should get data category that I updated

  Scenario: As an admin i can update category by leaving one of the fields blank
    When I send request to update category by leaving one of the fields blank
    Then I receive status code 400 Bad Request
    And I received an error message that all fields must be filled in

