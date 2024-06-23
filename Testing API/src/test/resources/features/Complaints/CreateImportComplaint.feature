@CreateImportComplaints
Feature: Create Import Complaints
  As an admin
  I want to create a import complaint
  So that import complaint was successfully

  Scenario: As an user I can create a new complaints with valid credentials
    Given I set API endpoint for create new import complaint
    When I send request endpoint for create new import complaint
    Then I receive status code 200 OK
    And I receive valid status for import complaints was success