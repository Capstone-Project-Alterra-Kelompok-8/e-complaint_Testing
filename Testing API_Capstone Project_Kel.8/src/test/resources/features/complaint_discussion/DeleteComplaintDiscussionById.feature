Feature: Delete complaint discussion by ID
  As a admin
  I want to delete complaint discussion by ID
  So that I can see complaint discussion has been delete

  #positive
  Scenario: As a admin I can delete complaint discussion by ID with valid endpoint and method
    Given I set a valid API endpoint and method
    When I send a request to delete complaint discussion by ID
    Then I receive a status code 200 OK
    And I see complaint discussion has been delete with valid

  #negative
  Scenario: As a admin I can't delete complaint discussion by ID with wrong method
    Given I set a valid API endpoint with the wrong method
    When I send a request to delete complaint discussion by ID with invalid method
    Then I receive on status code 404 not found

  #negative
  Scenario: As a admin I can't delete complaint discussion by ID with wrong endpoint
    Given I set a valid method and an incorrect endpoint
    When I send request to delete complaint discussion by ID with invalid endpoint
    Then I received a status code 404 not found

  #negative
  Scenario: As a admin I can't delete complaint discussion by ID with invalid ID
    Given I set a valid method and an invalid API endpoint ID
    When I send a request to delete complaint discussion by ID with invalid ID
    Then I received status code 404 not found