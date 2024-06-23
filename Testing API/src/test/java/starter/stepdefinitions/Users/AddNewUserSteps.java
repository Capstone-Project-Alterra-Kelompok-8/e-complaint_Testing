package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.AddNewUser;

public class AddNewUserSteps {
    @Steps
    AddNewUser addNewUser;

    @Given("I set users API endpoint for create new user")
    public void setApiUser(){
        addNewUser.setApiNewUser();
    }

    @When("I send request endpoint for create new user")
    public void sendRequestUser(){
        addNewUser.sendCreateUser();
    }

    @And("I receive valid data for my user")
    public void receiveUserData(){
        addNewUser.receiveValidDataForNewUser();
    }

}