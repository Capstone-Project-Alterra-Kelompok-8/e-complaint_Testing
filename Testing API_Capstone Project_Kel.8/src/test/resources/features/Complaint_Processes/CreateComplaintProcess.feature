@CreateComplaintProcess
Feature: Create a Complaint Process with Valid Credentials
  As an admin
  I want to create a complaint process
  So that complaint process was successfully created

  Scenario: As an admin I can create a complaint process
    Given I set API endpoint for create a complaint process
    When I send request endpoint for create a complaint process with valid credentials
    Then I receive status code 201 Created
    And I receive valid data for complaint process