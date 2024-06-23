@CreateAdminAccount
Feature: Create a New Admin Account with Valid Credentials
  As an admin
  I want to create a new account
  So that my account was successfully created

  Scenario: As an admin I can create a new admin account with valid credentials
    Given I set API endpoint for create a new admin account
    When I send request endpoint for create a new admin account with valid credentials
    Then I receive status code 201 Created
    And I receive valid data for my new account