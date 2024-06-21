@DeleteComplaint
Feature: Delete Complaint by ID
  As an user
  I want to delete complaint by valid ID
  So that the complaint can be removed

  Scenario: As an admin I can delete complaint with valid ID
    Given I set API endpoint for delete complaint with valid ID
    When I send request endpoint for delete complaint
    Then I receive status code 200 OK response
    And I receive response body that complaint deleted

  Scenario: As an admin I can delete complaint with Invalid ID
    Given I set API endpoint for delete complaint with Invalid ID
    When I send request endpoint for delete complaint with invalid ID
    Then I receive status code 404 not found
    And I receive response body that complaint not found