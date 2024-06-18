Feature: Get news by ID
  As a admin
  I want to get news by ID
  So that I can see news data by ID

  #positive
  Scenario: As a admin I can get news data by ID with valid endpoint and method
    Given I set API endpoint and method with valid
    When I send a request to get news data by ID
    Then I get status code 200 OK
    And I get news data by ID with valid

  #negative
  Scenario: As a admin I can't get news data by ID with valid endpoint and wrong method
    Given I set with valid API endpoint and wrong method
    When I send request to get news data by ID with invalid method
    Then I received the status code 404 not found

  #negative
  Scenario: As a admin I can't get news data by ID with valid method and wrong endpoint
    Given I set with valid method and wrong API endpoint
    When I send request to get news data by ID with invalid endpoint
    Then I get status code 404 not found

  #negative
  Scenario: As a admin I can't get news data by ID with wrong ID
    Given I set with valid method and invalid ID API endpoint
    When I send request to get news data by ID with invalid ID
    Then I see status code 404 not found