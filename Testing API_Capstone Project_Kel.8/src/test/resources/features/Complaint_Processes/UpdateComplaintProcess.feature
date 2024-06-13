@UpdateComplaintProcess
Feature: Update Complaint Process
  As an admin
  I want to update complaint process
  So that I can update information for specific complaint process

  Scenario: As an admin i can update complaint process
    Given I set API endpoint for update complaint process
    When I send request to update complaint process
    Then I receive status code 200 OK response
    And I should get data complaint process that I updated