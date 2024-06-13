@UpdateComplaint
Feature: Update Complaint
  As an user
  I want to update my complaint
  So that I can update information for specific complaint

  Scenario: As an user i can update my complaint
    Given I set API endpoint for update complaint user
    When I send request to update complaint user
    Then I receive status code 200 OK response
    And I should get data complaint that I updated