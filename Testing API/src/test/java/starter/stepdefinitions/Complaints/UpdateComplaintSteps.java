package starter.stepdefinitions.Complaints;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaints.UpdateComplaint;

public class UpdateComplaintSteps {
    @Steps
    UpdateComplaint updateComplaint;

    @Given("I set API endpoint for update complaint user")
    public void setApiPutEndValidComplaintUser(){
        updateComplaint.setApiUpdateComplaint();
    }

    @When("I send request to update complaint user by valid credentials")
    public void sendPutRequestValidComplaintUser(){
        updateComplaint.sendPutRequestUpdateComplaint();
    }

    @And("I should get data complaint that I updated")
    public void ReceiveDataComplaintUpdated(){
        updateComplaint.receiveComplaintDataUpdated();
    }

    @When("I send request to update complaint user by invalid credentials\\(invalid regency_id)")
    public void sendPutRequestInValidComplaintUser(){
        updateComplaint.sendPutInvalidRequestUpdateComplaint();
    }

    @And("I receive error message that regency not found")
    public void ReceiveInvalidDataComplaintUpdated(){
        updateComplaint.receiveErrorMessageUpdateComplaint();
    }
}
