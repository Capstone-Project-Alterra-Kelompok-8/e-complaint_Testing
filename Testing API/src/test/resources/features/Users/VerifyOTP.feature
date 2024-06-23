#@VerifyOTP
#Feature: Verify OTP
#  As an user
#  I want to verify otp with valid otp
#  So I got a response that the OTP was successfully verified
#
#  Scenario: As an user I want to verify otp with valid otp
#    Given I set API endpoint for verify otp
#    When I send request endpoint for verify otp
#    Then I receive status code 200 OK response
#    And I receive response body for Success Verify OTP