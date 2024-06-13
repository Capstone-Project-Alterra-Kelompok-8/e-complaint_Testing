package starter.stepdefinitions.Admins;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Admins.Login;

public class LoginSteps {

    @Steps
    Login login;

    @Given("I set API endpoint to Login admin")
    public void setApiEndLogin(){
        login.setApiLogin();
    }

    @When("I send request to login and fill valid credential")
    public void sendLoginRequest() {
        login.sendLoginValid();
    }

    @And("I receive my logged in account data and get token")
    public void receiveValidToken(){
        login.receiveValidLogin();
    }

}