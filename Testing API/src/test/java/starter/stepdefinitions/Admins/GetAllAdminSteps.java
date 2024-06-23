package starter.stepdefinitions.Admins;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Admins.GetAllAdmin;
import starter.user.StatusCode;

public class GetAllAdminSteps {
    @Steps
    GetAllAdmin getAllAdmin;

    @Steps
    StatusCode statusCode;

    @Given("I set API endpoint for get all admin")
    public void setApiEndProfile(){
        getAllAdmin.setApiEndGetAllAdmin();
    }

    @When("I send request endpoint for get all admin")
    public void sendUserRequest(){
        getAllAdmin.sendRequestAdmin();
    }

    @And("I receive data for all admin information")
    public void receiveValidProfile(){
        getAllAdmin.receiveValidAdmin();
    }
}