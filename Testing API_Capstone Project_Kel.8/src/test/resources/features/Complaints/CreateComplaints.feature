@CreateComplaints
Feature: Create Complaints with Valid Credentials
  As an user
  I want to create a new complaints with valid credentials
  So that my complaints was successfully created

  Scenario: As an user I can create a new complaints with valid credentials
    Given I set API endpoint for create new complaints
    When I send request endpoint for create new complaints with valid credentials
    Then I receive status code 201 Created
    And I receive valid data for my complaints