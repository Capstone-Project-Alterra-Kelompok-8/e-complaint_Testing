@DeleteComplaintProcess
Feature: Delete Complaint Process by ID
  As an user
  I want to delete complaint process by valid ID
  So that the complaint process can be removed

  Scenario: As an admin I can delete complaint process
    Given I set API endpoint for delete complaint process with valid ID
    When I send request endpoint for delete complaint process
    Then I receive status code 200 OK response
    And I receive response body that complaint process deleted