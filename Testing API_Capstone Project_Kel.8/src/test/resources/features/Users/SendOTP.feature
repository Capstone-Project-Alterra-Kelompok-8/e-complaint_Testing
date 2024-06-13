@SendOTP
Feature: Send OTP
  As an user
  I want to send otp with valid email
  So I received an otp in my email

  Scenario: As an user I want to send otp with valid email
    Given I set users API endpoint for send otp
    When I send request endpoint for send otp with valid email
    Then I receive status code 200 OK response
    And I receive response body for receive otp success