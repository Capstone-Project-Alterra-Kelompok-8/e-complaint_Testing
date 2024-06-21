package starter.stepdefinitions.Complaints;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaints.CreateComplaints;

public class CreateComplaintsSteps {
    @Steps
    CreateComplaints createComplaints;

    @Given("I set API endpoint for create new complaints")
    public void setApiComplaint(){
        createComplaints.setApiNewComplaint();
    }

    @When("I send request endpoint for create new complaints with valid credentials")
    public void sendRequestComplaint(){
        createComplaints.sendCreateComplaint();
    }

    @And("I receive valid data for my complaints")
    public void receiveComplaintData(){
        createComplaints.receiveValidDataForNewComplaint();
    }

    @When("I send request endpoint for create new complaints with Invalid credentials\\(Invalid category_id)")
    public void sendRequestInvalidComplaint(){
        createComplaints.sendInvalidCreateComplaint();
    }


}
