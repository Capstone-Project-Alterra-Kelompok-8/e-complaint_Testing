@LoginUser
Feature: Login User
  As an user
  I want to Login
  So that i can get token for access

  Scenario: As an user i want to Login using valid credential
    Given I set API endpoint to Login User
    When I send request to login User and fill valid credential(email, password)
    Then I receive status code 200 OK response
    And I receive my logged in account data user