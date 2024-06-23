@CreateComplaintProcess
Feature: Create a Complaint Process
  As an admin
  I want to create a complaint process
  So that complaint process was successfully created

  Background:
    Given I set API endpoint for create a complaint process

  Scenario: As an admin I can create a complaint process
    When I send request endpoint for create a complaint process with valid credentials
    Then I receive status code 201 Created
    And I receive valid data for complaint process

  Scenario: As an admin I can create a complaint process with invalid status
    When I send request endpoint for create a complaint process with invalid status
    Then I receive status code 400 Bad Request
    And I receive error message that invalid status