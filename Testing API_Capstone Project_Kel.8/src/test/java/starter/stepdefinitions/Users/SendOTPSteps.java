package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.SendOTP;

public class SendOTPSteps {
    @Steps
    SendOTP sendOTP;

    @Given("I set users API endpoint for send otp")
    public void setApiOTP(){
        sendOTP.setApiOTPUser();
    }

    @When("I send request endpoint for send otp with valid email")
    public void sendOTPUser(){
        sendOTP.sendValidOTPUser();
    }

    @And("I receive response body for receive otp success")
    public void receiveOTPUser(){
        sendOTP.receiveValidDataForOTPUser();
    }
}
