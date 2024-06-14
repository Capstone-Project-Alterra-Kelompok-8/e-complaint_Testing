Feature: Get all complaint discussion
  As a admin
  I want to get all complaint discussion
  So that I can see all complaint discussion

  #positive
  Scenario: As a admin I can get all complaint discussion data with valid endpoint and method
    Given I set the valid API endpoint and method
    When I send a request to get all complaint discussion data
    Then I receive status code 200 OK
    And I get all complaint discussion data with valid

  #negative
  Scenario: As a admin I can't get all complaint discussion data with valid endpoint and wrong method
    Given I set the valid API endpoint and incorrect method
    When I send request to get all complaint discussion data with invalid method
    Then I receive a 404 not found status code

  #negative
  Scenario: As a admin I can't get all complaint discussion data with valid method and wrong endpoint
    Given I set a valid method and an incorrect API endpoint
    When I send request to get all complaint discussion data with invalid endpoint
    Then I receive a status code 404 not found