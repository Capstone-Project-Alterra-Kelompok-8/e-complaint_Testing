package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.GetAllUser;

public class GetAllUserSteps {

    @Steps
    GetAllUser getAllUser;

    @Given("I set API endpoint for get all users")
    public void setApiMyUser(){
        getAllUser.setApiAllUser();
    }

    @When("I send request to get all users")
    public void sendUserRequest(){
        getAllUser.sendRequestAllUser();
    }

    @And("I receive all of users")
    public void receiveMyUser(){
        getAllUser.receiveValidUser();
    }
}