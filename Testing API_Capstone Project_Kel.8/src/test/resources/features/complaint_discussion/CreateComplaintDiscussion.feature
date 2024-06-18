Feature: Create complaint discussion
  As a admin
  I want to create complaint discussion
  So that I can see new complaint discussion

  #positive
  Scenario: As a admin I can create complaint discussion with valid endpoint and method
    Given I set on valid API endpoint and method
    When I send a request to create complaint discussion
    Then I receive on status code 201 created
    And I create complaint discussion with valid

  #negative
  Scenario: As a admin I can't create complaint discussion with wrong method
    Given I set on valid API endpoint and incorrect method
    When I send request to create complaint discussion with invalid method
    Then I receive on 404 not found status code

  #negative
  Scenario: As a admin I can't create complaint discussion with wrong endpoint
    Given I set on valid method and an incorrect API endpoint
    When I send request to create complaint discussion with invalid endpoint
    Then I receive code 404 not found