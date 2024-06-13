package starter.stepdefinitions.Complaints;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaints.GetComplaintWithValidID;

public class GetComplaintWithValidIDSteps {
    @Steps
    GetComplaintWithValidID getComplaintWithValidID;

    @Given("I set API endpoint with an valid ID to get complaint by ID")
    public void setApiGetEndValidIDComplaint(){
        getComplaintWithValidID.setApiGetEndValidComplaint();
    }

    @When("I send request endpoint for get complaint by valid ID")
    public void sendGetRequestValidIDComplaint(){
        getComplaintWithValidID.sendGetRequestValidComplaint();
    }

    @And("I receive complaint information based on id by valid ID")
    public void receiveDetailsValidIDComplaint(){
        getComplaintWithValidID.receiveValidIDComplaint();
    }
}
