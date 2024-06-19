@UpdateComplaint
Feature: Update Complaint
  As an user
  I want to update my complaint
  So that I can update information for specific complaint

  Background:
    Given I set API endpoint for update complaint user

  Scenario: As an user i can update my complaint by valid credentials
    When I send request to update complaint user by valid credentials
    Then I receive status code 200 OK response
    And I should get data complaint that I updated

  Scenario: As an user i can update my complaint by invalid credentials
    When I send request to update complaint user by invalid credentials(invalid regency_id)
    Then I receive status code 404 not found
    And I receive error message that regency not found