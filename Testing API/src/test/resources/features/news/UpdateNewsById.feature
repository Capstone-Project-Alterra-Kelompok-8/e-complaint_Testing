Feature: Update news by ID
  As a admin
  I want to update news by ID
  So that I can see news data has been update

  #positive
  Scenario: As a admin I can update news data by ID with valid endpoint and method
    Given I set valid endpoint and method with validly
    When I send a request to update news data by ID
    Then I see status 200 OK
    And I see news data has been update with valid

  #negative
  Scenario: As a admin I can't update news data by ID with wrong method
    Given I set with valid endpoint and wrong method
    When I send a request to update news data by ID with invalid method
    Then I see status 404 not found

  #negative
  Scenario: As a admin I can't update news data by ID with wrong endpoint
    Given I set with valid method and incorrect endpoint
    When I send request to update news data by ID with invalid endpoint
    Then I see status in 404 not found

  #negative
  Scenario: As a admin I can't update news data by ID with invalid ID
    Given I set valid method with invalid API endpoint ID
    When I send a request to update news data by ID with invalid ID
    Then I see 404 not found