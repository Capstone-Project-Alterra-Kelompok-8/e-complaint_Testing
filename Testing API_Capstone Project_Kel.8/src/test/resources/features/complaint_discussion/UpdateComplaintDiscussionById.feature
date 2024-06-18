Feature: Update complaint discussion by ID
  As a admin
  I want to update complaint discussion by ID
  So that I can see complaint discussion has been update

  #positive
  Scenario: As a admin I can update complaint discussion by ID with valid endpoint and method
    Given I set with valid API endpoint and method
    When I send a request to update complaint discussion by ID
    Then I receive on status code 200 OK
    And I see complaint discussion has been update with valid

  #negative
  Scenario: As a admin I can't update complaint discussion by ID with wrong method
    Given I set with valid API endpoint and with wrong method
    When I send a request to update complaint discussion by ID with invalid method
    Then I receive status 404 not found

  #negative
  Scenario: As a admin I can't update complaint discussion by ID with wrong endpoint
    Given I set with valid method and an incorrect endpoint
    When I send request to update complaint discussion by ID with invalid endpoint
    Then I received status 404 not found

  #negative
  Scenario: As a admin I can't update complaint discussion by ID with invalid ID
    Given I set with valid method and an invalid API endpoint ID
    When I send a request to update complaint discussion by ID with invalid ID
    Then I received 404 not found