package starter.stepdefinitions.Regencies;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Regencies.GetAllRegencies;

public class GetAllRegenciesSteps {
    @Steps
    GetAllRegencies getAllRegencies;

    @Given("I set users API endpoint for get all regencies")
    public void setApiMyUser(){
        getAllRegencies.setApiAllRegencies();
    }

    @When("I send GET request to get all regencies")
    public void sendUserRequest(){
        getAllRegencies.sendRequestAllRegencies();
    }

    @And("I receive all of regencies")
    public void receiveMyUser(){
        getAllRegencies.receiveValidRegencies();
    }
}
