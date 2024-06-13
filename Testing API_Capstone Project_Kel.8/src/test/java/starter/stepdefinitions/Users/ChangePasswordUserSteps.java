package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.ChangePasswordUser;

public class ChangePasswordUserSteps {
    @Steps
    ChangePasswordUser changePasswordUser;

    @Given("I set API endpoint for change password user")
    public void setApiPassUser(){
        changePasswordUser.setApiPassUser();
    }

    @When("I send request endpoint for change password user with valid credentials")
    public void sendRequestPassUser(){
        changePasswordUser.sendPassUser();
    }

    @And("I receive response body for my user password was successfully changed")
    public void receivePassUserData(){
        changePasswordUser.receiveValidDataForPassUser();
    }
}
