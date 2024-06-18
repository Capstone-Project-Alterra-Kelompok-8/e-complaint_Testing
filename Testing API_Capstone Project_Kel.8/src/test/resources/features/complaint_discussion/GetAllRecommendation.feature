Feature: Get all recommendation
  As a admin
  I want to get all recommendation
  So that I can see all recommendation

  #positive
  Scenario: As a admin I can get all recommendation with valid endpoint and method
    Given I set the API endpoint and method with valid
    When I send a request to get all recommendation
    Then I get a status code 200 OK
    And I get all recommendation with valid

  #negative
  Scenario: As a admin I can't get all recommendation with wrong method
    Given I set with valid API endpoint and incorrect method
    When I send request to get all recommendation with invalid method
    Then I get 404 not found status code

  #negative
  Scenario: As a admin I can't get all recommendation with wrong endpoint
    Given I set with valid method and an incorrect API endpoint
    When I send request to get all recommendation with invalid endpoint
    Then I get the status code 404 not found