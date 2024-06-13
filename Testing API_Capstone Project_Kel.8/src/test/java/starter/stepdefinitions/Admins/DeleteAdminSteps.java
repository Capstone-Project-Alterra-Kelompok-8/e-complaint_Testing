package starter.stepdefinitions.Admins;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Admins.DeleteAdmin;

public class DeleteAdminSteps {
    @Steps
    DeleteAdmin deleteAdmin;

    @Given("I set API endpoint for delete admin with valid ID")
    public void setDeleteValidAdminSteps(){
        deleteAdmin.setApiDeleteAdminEndpoint();
    }

    @When("I send request endpoint for delete admin")
    public void sendDeleteAdminRequest(){
        deleteAdmin.sendDeleteAdminRequest();
    }

    @And("I receive response body for delete admin")
    public void receiveDeleteResponse(){
        deleteAdmin.receiveResponseBody();
    }
}
