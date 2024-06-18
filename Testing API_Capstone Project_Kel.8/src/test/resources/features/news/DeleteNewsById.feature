Feature: Delete news by ID
  As a admin
  I want to delete news by ID
  So that I can see news has been delete

  #positive
  Scenario: As a admin I can delete news by ID with valid endpoint and method
    Given I set valid endpoint and method
    When I send a request to delete news by ID
    Then I receive in status code 200 OK
    And I see news has been delete with valid

  #negative
  Scenario: As a admin I can't delete news by ID with wrong method
    Given I set valid API endpoint with wrong method
    When I send a request to delete news by ID with invalid method
    Then I receive status code 404 not found

  #negative
  Scenario: As a admin I can't delete news by ID with wrong endpoint
    Given I set valid method and wrong endpoint
    When I send request to delete news by ID with invalid endpoint
    Then I received in status code 404 not found

  #negative
  Scenario: As a admin I can't delete news by ID with invalid ID
    Given I set with valid method and invalid API endpoint ID
    When I send a request to delete news by ID with invalid ID
    Then I get code 404 not found