@DeleteAdminByID
Feature: Delete Admin with valid ID
  As an admin
  I want to delete admin with valid ID
  So that the admin account can be removed

  Scenario: As an admin I can delete admin with valid ID
    Given I set API endpoint for delete admin with valid ID
    When I send request endpoint for delete admin
    Then I receive status code 200 OK response
    And I receive response body for delete admin