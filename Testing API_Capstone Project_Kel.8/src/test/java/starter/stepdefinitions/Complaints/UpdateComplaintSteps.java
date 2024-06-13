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
    public void setApiGetEndValidComplaintUser(){
        updateComplaint.setApiUpdateComplaint();
    }

    @When("I send request to update complaint user")
    public void sendGetRequestValidComplaintUser(){
        updateComplaint.sendPutRequestUpdateComplaint();
    }

    @And("I should get data complaint that I updated")
    public void ReceiveDataComplaintUpdated(){
        updateComplaint.receiveComplaintDataUpdated();
    }
}
