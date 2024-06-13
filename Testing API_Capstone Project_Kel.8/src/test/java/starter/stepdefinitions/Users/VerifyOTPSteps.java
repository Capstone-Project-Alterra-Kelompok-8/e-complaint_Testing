package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.VerifyOTP;

public class VerifyOTPSteps {
    @Steps
    VerifyOTP verifyOTP;

    @Given("I set API endpoint for verify otp")
    public void setApiVerifyOTP(){
        verifyOTP.setApiVerifyOTPUser();
    }

    @When("I send request endpoint for verify otp")
    public void sendVerifyOTPUser(){
        verifyOTP.sendVerifySuccessdOTPUser();
    }

    @And("I receive response body for Success Verify OTP")
    public void receiveResponseVerifyOTPUser(){
        verifyOTP.receiveValidDataForVerifyOTPUser();
    }
}
