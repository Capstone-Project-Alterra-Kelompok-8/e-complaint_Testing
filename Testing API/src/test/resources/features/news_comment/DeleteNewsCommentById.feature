Feature: Delete news comment by ID
  As a admin
  I want to delete news comment by ID
  So that I can see news comment has been delete

  #positive
  Scenario: As a admin I can delete news comment by ID with valid endpoint and method
    Given I set with valid endpoint and method
    When I send a request to delete news comment by ID
    Then I received status code 200 OK
    And I see news comment has been delete with valid

  #negative
  Scenario: As a admin I can't delete news comment by ID with wrong method
    Given I set with valid API endpoint with wrong method
    When I send a request to delete news comment by ID with invalid method
    Then I get in status code 404 not found

  #negative
  Scenario: As a admin I can't delete news comment by ID with wrong endpoint
    Given I set with valid method and wrong endpoint
    When I send request to delete news comment by ID with invalid endpoint
    Then I received on status code 404 not found

  #negative
  Scenario: As a admin I can't delete news comment by ID with invalid ID
    Given I set with valid method and invalid endpoint ID
    When I send a request to delete news comment by ID with invalid ID
    Then I received a status code 400 bad request