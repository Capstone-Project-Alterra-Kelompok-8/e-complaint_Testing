@UpdateComplaintProcess
Feature: Update Complaint Process
  As an admin
  I want to update complaint process
  So that I can update information for specific complaint process

  Background:
    Given I set API endpoint for update complaint process

  Scenario: As an admin i can update complaint process
    When I send request to update complaint process by valid credentials
    Then I receive status code 200 OK response
    And I should get data complaint process that I updated

  Scenario: As an admin i can update complaint process by blank field
    When I send request to update complaint process by blank field
    Then I receive status code 400 Bad Request
    And I received an error message that all fields must be filled in