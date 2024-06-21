package starter.stepdefinitions.Complaints;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaints.GetComplaintByID;

public class GetComplaintByIDSteps {
    @Steps
    GetComplaintByID getComplaintByID;

    @Given("I set API endpoint with an valid ID to get complaint by valid ID")
    public void setApiGetEndValidIDComplaint(){
        getComplaintByID.setApiGetEndValidComplaint();
    }

    @When("I send request endpoint for get complaint by ID")
    public void sendGetRequestValidIDComplaint(){
        getComplaintByID.sendGetRequestValidComplaint();
    }

    @And("I receive complaint information based on id by valid ID")
    public void receiveDetailsValidIDComplaint(){
        getComplaintByID.receiveValidIDComplaint();
    }

    @Given("I set API endpoint with an valid ID to get complaint by Invalid ID")
    public void setApiGetEndInValidIDComplaint(){
        getComplaintByID.setApiGetEndInValidComplaint();
    }

    @When("I send request endpoint for get complaint by invalid ID")
    public void sendGetRequestInValidIDComplaint(){
        getComplaintByID.sendGetRequestInValidComplaint();
    }
}
