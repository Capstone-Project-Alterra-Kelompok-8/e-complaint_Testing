@UpdateCategory
Feature: Update Category with
  As an admin
  I want to update category
  So that I can update information for specific category

  Scenario: As an admin i can update category
    Given I set API endpoint for update category
    When I send request to update category
    Then I receive status code 200 OK response
    And I should get data category that I updated