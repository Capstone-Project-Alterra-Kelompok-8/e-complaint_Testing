package starter.stepdefinitions.Admins;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Admins.CreateAdminAccount;

public class CreateAdminAccountSteps {
    @Steps
    CreateAdminAccount createAdminAccount;

    @Given("I set API endpoint for create a new admin account")
    public void setApiNewAdmin(){
        createAdminAccount.setApiNewAdminAccount();
    }

    @When("I send request endpoint for create a new admin account with valid credentials")
    public void sendRequestNewAdmin(){
        createAdminAccount.sendCreateAdminRequest();
    }

    @And("I receive valid data for my new account")
    public void receiveNewAdmin(){
        createAdminAccount.receiveValidDataForCreateNewAdmin();
    }
}
