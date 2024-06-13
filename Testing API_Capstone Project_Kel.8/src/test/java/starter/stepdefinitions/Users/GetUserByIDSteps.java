package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.GetUserByID;

public class GetUserByIDSteps {
    @Steps
    GetUserByID getUserByID;

    @Given("I set API endpoint for get user with valid id")
    public void setApiMyUserByID(){
        getUserByID.setApiMyUserById();
    }

    @When("I send request to get user information with valid ID")
    public void sendUserRequestByID(){
        getUserByID.sendRequestMyUserById();
    }

    @And("I receive detail user information with valid ID")
    public void receiveMyUserByID(){
        getUserByID.receiveValidUserById();
    }
}