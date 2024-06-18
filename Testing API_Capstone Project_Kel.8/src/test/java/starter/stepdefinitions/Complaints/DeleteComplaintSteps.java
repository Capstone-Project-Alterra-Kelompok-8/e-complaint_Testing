package starter.stepdefinitions.Complaints;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaints.DeleteComplaint;

public class DeleteComplaintSteps {
    @Steps
    DeleteComplaint deleteComplaint;

    @Given("I set API endpoint for delete complaint with valid ID")
    public void setDeleteValidComplaint(){
        deleteComplaint.setApiDeleteComplaintEndpoint();
    }

    @When("I send request endpoint for delete complaint")
    public void sendDeleteComplaintRequest(){
        deleteComplaint.sendDeleteComplaintUserRequest();
    }

    @And("I receive response body that complaint deleted")
    public void receiveDeleteComplaintResponse(){
        deleteComplaint.receiveComplaintResponseBody();
    }

    @Given("I set API endpoint for delete complaint with Invalid ID")
    public void setDeleteInValidComplaint(){
        deleteComplaint.setApiInvalidDeleteComplaintEndpoint();
    }
    @When("I send request endpoint for delete complaint with invalid ID")
    public void sendInvalidDeleteComplaintRequest(){
        deleteComplaint.sendInvalidDeleteComplaintUserRequest();
    }
}
