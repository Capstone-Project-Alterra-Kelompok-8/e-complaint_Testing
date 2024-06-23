package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.UpdateUser;


public class UpdateUserSteps {

    @Steps
    UpdateUser updateUser;

    @Given("I set users api endpoint for update user")
    public void setApiGetEndInvalidIdProfilee(){
        updateUser.setApiUpdateUser();
    }

    @When("I send request to update user with valid credentials")
    public void sendGetRequestInvalidIdProfilee(){
        updateUser.sendPUTupdateUser();
    }

    @And("I receive newly updated user")
    public void receiveValidProfilee(){
        updateUser.receiveValidUser();
    }

}