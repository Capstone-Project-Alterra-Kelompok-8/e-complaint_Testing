package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.LoginUser;

public class LoginUserSteps {
    @Steps
    LoginUser loginUser;

    @Given("I set API endpoint to Login User")
    public void setApiEndLoginUser(){
        loginUser.setApiUserLogin();
    }

    @When("I send request to login User and fill valid credential\\(email, password)")
    public void sendLoginUserRequest() {
        loginUser.sendUserLoginValid();
    }

    @And("I receive my logged in account data user")
    public void receiveValidUserToken(){
        loginUser.receiveValidUserLogin();
    }
}
