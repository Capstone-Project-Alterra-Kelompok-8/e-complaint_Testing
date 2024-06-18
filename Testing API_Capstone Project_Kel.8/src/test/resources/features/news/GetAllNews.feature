Feature: Get all news
  As a admin
  I want to get all news data
  So that I can see all news data

  #positive
  Scenario: As a admin I can get all news data with valid endpoint and method
    Given I set valid API endpoint and method
    When I send a request to get all news data
    Then I receive the status code 200 OK
    And I get all news data with valid

  #negative
  Scenario: As a admin I can't get all news data with valid endpoint and wrong method
    Given I set valid API endpoint and wrong method
    When I send request to get all news data with invalid method
    Then I receive the status code 404 not found

  #negative
  Scenario: As a admin I can't get all news data with valid method and wrong endpoint
    Given I set valid method and wrong API endpoint
    When I send request to get all news data with invalid endpoint
    Then I receive in status code 404 not found