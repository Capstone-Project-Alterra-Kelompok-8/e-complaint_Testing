@GetAllComplaints
Feature: Get All Complaints
  As an admin
  I want to get all complaints details
  So That i can get 200 OK response and data for all complaints

  Scenario: As an admin i want to get all complaints
    Given I set API endpoint for get all complaints
    When I send request endpoint for get all complaints
    Then I receive status code 200 OK response
    And I receive data for all complaints details