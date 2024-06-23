package starter.stepdefinitions.Complaints;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaints.GetAllComplaints;

public class GetAllComplaintsSteps {
    @Steps
    GetAllComplaints getAllComplaints;

    @Given("I set API endpoint for get all complaints")
    public void setApiEndComplaints(){
        getAllComplaints.setApiEndGetAllComplaints();
    }

    @When("I send request endpoint for get all complaints")
    public void sendGetAllComplaintsRequest(){
        getAllComplaints.sendRequestGetAllComplaints();
    }

    @And("I receive data for all complaints details")
    public void receiveValidComplaints(){
        getAllComplaints.receiveValidAllComplaints();
    }
}
