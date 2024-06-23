@DeleteComplaintProcess
Feature: Delete Complaint Process by ID
  As an user
  I want to delete complaint process by ID
  So that the complaint process can be removed

  Scenario: As an admin I can delete complaint process by valid ID
    Given I set API endpoint for delete complaint process with valid ID
    When I send request endpoint for delete complaint process
    Then I receive status code 200 OK response
    And I receive response body that complaint process deleted

  Scenario: As an admin I can delete complaint process by invalid ID
    Given I set API endpoint for delete complaint process with invalid ID
    When I send request endpoint for delete complaint process with invalid ID
    Then I receive status code 404 not found
    And I receive response body that complaint process not found