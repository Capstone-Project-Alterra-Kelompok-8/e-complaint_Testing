@Login
Feature: Login
  As an admin
  I want to Login
  So that i can get token for access

  Scenario: As an admin i want to Login using valid credential
    Given I set API endpoint to Login admin
    When I send request to login and fill valid credential
    Then I receive status code 200 OK response
    And I receive my logged in account data and get token