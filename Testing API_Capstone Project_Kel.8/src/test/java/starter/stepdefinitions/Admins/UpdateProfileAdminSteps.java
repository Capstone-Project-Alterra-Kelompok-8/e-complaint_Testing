package starter.stepdefinitions.Admins;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Admins.UpdateProfileAdmin;


public class UpdateProfileAdminSteps {

    @Steps
    UpdateProfileAdmin updateProfileAdmin;

    @Given("I set API endpoint for update profile admin")
    public void setApiGetEndValidIdProfile(){
        updateProfileAdmin.setApiUpdateAdmin();
    }

    @When("I send request to update profile admin")
    public void sendGetRequestValidIdProfile(){
        updateProfileAdmin.sendPutRequestUpdateAdmin();
    }

    @And("I should get the data admin that I updated")
    public void ReceiveDataUpdated(){
        updateProfileAdmin.receiveDataAdminUpdated();
    }
}