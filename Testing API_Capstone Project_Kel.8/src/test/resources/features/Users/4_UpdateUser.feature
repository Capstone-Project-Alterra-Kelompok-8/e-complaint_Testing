@UpdateUser
Feature: Update User with Valid Credentials
  As an user
  I want to update user
  So that I can update a newest data for that user

  Scenario: As an user i want to update user with valid credentials
    Given I set users api endpoint for update user
    When I send request to update user with valid credentials
    Then I receive status code 200 OK response
    And I receive newly updated user