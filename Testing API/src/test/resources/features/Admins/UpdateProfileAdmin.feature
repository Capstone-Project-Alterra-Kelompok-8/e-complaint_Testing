@UpdateProfileAdmin
Feature: Update Profile Admin with valid credentials
  As an admin
  I want to update profile admin with valid credentials
  So that I can update information for specific items in my admin

  Scenario: As an admin i can update profile admin with valid credentials
    Given I set API endpoint for update profile admin
    When I send request to update profile admin
    Then I receive status code 200 OK response
    And I should get the data admin that I updated