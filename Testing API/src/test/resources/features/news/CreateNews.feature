Feature: Create news
  As a admin
  I want to create news
  So that I can see new news

  #positive
  Scenario: As a admin I can create news data with valid endpoint and method
    Given I set the valid endpoint and method
    When I send a request to create news data
    Then I received a status code 201 created
    And I create news data with valid

  #negative
  Scenario: As a admin I can't create news data with valid endpoint and wrong method
    Given I set valid endpoint and incorrect method
    When I send request to create news data with invalid method
    Then I received 404 not found status code

  #negative
  Scenario: As a admin I can't create news data with valid method and wrong endpoint
    Given I set valid method and an incorrect API endpoint
    When I send request to create news data with invalid endpoint
    Then I receive in status 404 not found