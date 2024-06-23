@CreateComplaints
Feature: Create Complaints
  As an user
  I want to create a new complaints with valid credentials
  So that my complaints was successfully created

  Background:
    Given I set API endpoint for create new complaints

  Scenario: As an user I can create a new complaints with valid credentials
    When I send request endpoint for create new complaints with valid credentials
    Then I receive status code 201 Created
    And I receive valid data for my complaints

  Scenario: As an user I can create a new complaints with Invalid credentials(Invalid category_id)
    When I send request endpoint for create new complaints with Invalid credentials(Invalid category_id)
    Then I receive status code 404 not found
    And I receive error message that category not found