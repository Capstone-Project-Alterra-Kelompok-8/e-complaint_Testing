@GetAllAdmin
Feature: Get All Admin
  As an admin
  I want to get all admin information
  So That i can get 200 OK response and data for all admin

  Scenario: As an admin i want to get all admin
    Given I set API endpoint for get all admin
    When I send request endpoint for get all admin
    Then I receive status code 200 OK response
    And I receive data for all admin information