package starter.stepdefinitions.Admins;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Admins.GetAdminWithValidId;


public class GetAdminWithValidIDSteps {

    @Steps
    GetAdminWithValidId getAdminWithValidId;

    @Given("I set API endpoint with an valid ID to get admin by ID")
    public void setApiGetEndInvalidIdProfile(){
        getAdminWithValidId.setApiGetEndValidAdmin();
    }

    @When("I send request endpoint for get admin by ID")
    public void sendGetRequestInvalidIdProfile(){
        getAdminWithValidId.sendGetRequestValidAdmin();
    }

    @And("I receive admin information based on id by ID")
    public void receiveAProductCategory(){
        getAdminWithValidId.receiveAdmin();
    }

}