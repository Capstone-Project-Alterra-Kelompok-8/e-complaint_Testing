Feature: Update news comment by ID
  As a admin
  I want to update news comment by ID
  So that I can see news comment has been update

  #positive
  Scenario: As a admin I can update news comment by ID with valid endpoint and method
    Given I set valid endpoint and method with valid
    When I send a request to update news comment by ID
    Then I received status 200 OK
    And I see news comment has been update with valid

  #negative
  Scenario: As a admin I can't update news comment by ID with wrong method
    Given I set valid endpoint with the wrong method
    When I send a request to update news comment by ID with invalid method
    Then I get status 404 not found

  #negative
  Scenario: As a admin I can't update news comment by ID with wrong endpoint
    Given I set valid method and an incorrect endpoint
    When I send request to update news comment by ID with invalid endpoint
    Then I get status in 404 not found

  #negative
  Scenario: As a admin I can't update news comment by ID with invalid ID
    Given I set valid method and invalid API endpoint ID
    When I send a request to update news comment by ID with invalid ID
    Then I received 400 bad request