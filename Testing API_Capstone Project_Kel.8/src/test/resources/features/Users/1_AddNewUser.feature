@AddNewUser
Feature: Add New User with Valid Credentials
  As an user
  I want to create a new User Valid Credentials
  So that my account was successfully created

  Scenario: As an user I can create a new user with valid credentials
    Given I set users API endpoint for create new user
    When I send request endpoint for create new user
    Then I receive status code 201 Created
    And I receive valid data for my user