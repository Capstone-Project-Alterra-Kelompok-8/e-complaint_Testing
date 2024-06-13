@DeleteCategory
Feature: Delete Category with valid ID
  As an admin
  I want to delete category with valid ID
  So that the category can be removed

  Scenario: As an admin I can delete category with valid ID
    Given I set API endpoint for delete category with valid ID
    When I send request endpoint for delete category
    Then I receive status code 200 OK response
    And I receive response body that category deleted