Feature: Create news comment by ID
  As a admin
  I want to create news comment by ID
  So that I can see new news comment

  #positive
  Scenario: As a admin I can create news comment by ID with valid endpoint and method
    Given I set a valid endpoint and method
    When I send a request to create news comment by ID
    Then I received on status code 201 created
    And I create news comment with valid

  #negative
  Scenario: As a admin I can't create news comment by ID with wrong method
    Given I set a valid API endpoint and incorrect method
    When I send request to create news comment by ID with invalid method
    Then I received on 404 not found status code

  #negative
  Scenario: As a admin I can't create news comment by ID with wrong endpoint
    Given I set the valid method and an incorrect API endpoint
    When I send request to create news comment by ID with invalid endpoint
    Then I received code 404 not found

  #negative
  Scenario: As a admin I can't create news comment by ID with invalid ID
    Given I set valid method and an invalid API endpoint ID
    When I send a request to create news comment by ID with invalid ID
    Then I received code 400 bad request