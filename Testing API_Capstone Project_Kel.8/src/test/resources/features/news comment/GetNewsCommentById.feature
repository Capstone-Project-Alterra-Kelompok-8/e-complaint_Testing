Feature: Get news comment by ID
  As a admin
  I want to get news comment by ID
  So that I can see news comment

  #positive
  Scenario: As a admin I can get news comment by ID with valid endpoint and method
    Given I set a API endpoint and method with valid
    When I send a request to get news comment by ID
    Then I get the status code 200 OK
    And I get news comment by ID with valid

  #negative
  Scenario: As a admin I can't get news comment by ID with wrong method
    Given I set with a valid API endpoint and wrong method
    When I send request to get news comment by ID with invalid method
    Then I get a status code 404 not found

  #negative
  Scenario: As a admin I can't get news comment by ID with wrong endpoint
    Given I set with a valid method and wrong API endpoint
    When I send request to get news comment by ID with invalid endpoint
    Then I get on status code 404 not found

  #negative
  Scenario: As a admin I can't get news comment by ID with wrong ID
    Given I set with a valid method and invalid ID API endpoint
    When I send request to get news comment by ID with invalid ID
    Then I get on status code 400 bad request