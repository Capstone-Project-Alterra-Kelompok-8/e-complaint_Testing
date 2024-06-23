package starter.stepdefinitions.complaintDiscussion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.complaintDiscussion.UpdateComplaintDiscussionById;

public class UpdateComplaintDiscussionByIdSteps {

    @Steps
    UpdateComplaintDiscussionById updateComplaintDiscussionByID;

    @Given("I set with valid API endpoint and method")
    public void setWithValidApiEndpointAndMethod(){
        updateComplaintDiscussionByID.setWithValidApiEndpointAndMethod();
    }
    @When("I send a request to update complaint discussion by ID")
    public void sendARequestToUpdateComplaintDiscussionById(){
        updateComplaintDiscussionByID.sendARequestToUpdateComplaintDiscussionById();
    }
    @Then("I receive on status code 200 OK")
    public void receiveOnStatusCode200(){
        updateComplaintDiscussionByID.receiveOnStatusCode200();
    }
    @And("I see complaint discussion has been update with valid")
    public void seeComplaintDiscussionHasBeenUpdateWithValid(){
        updateComplaintDiscussionByID.seeComplaintDiscussionHasBeenUpdateWithValid();
    }
    @Given("I set with valid API endpoint and with wrong method")
    public void setWithValidApiEndpointAndWithWrongMethod(){
        updateComplaintDiscussionByID.setWithValidApiEndpointAndWithWrongMethod();
    }
    @When("I send a request to update complaint discussion by ID with invalid method")
    public void sendARequestToUpdateComplaintDiscussionByIdWithInvalidMethod(){
        updateComplaintDiscussionByID.sendARequestToUpdateComplaintDiscussionByIdWithInvalidMethod();
    }
    @Then("I receive status 404 not found")
    public void receiveStatus404(){
        updateComplaintDiscussionByID.receiveStatus404();
    }
    @Given("I set with valid method and an incorrect endpoint")
    public void setWithValidMethodAndAnIncorrectEndpoint(){
        updateComplaintDiscussionByID.setWithValidMethodAndAnIncorrectEndpoint();
    }
    @When("I send request to update complaint discussion by ID with invalid endpoint")
    public void sendRequestToUpdateComplaintDiscussionByIdWithInvalidEndpoint(){
        updateComplaintDiscussionByID.sendRequestToUpdateComplaintDiscussionByIdWithInvalidEndpoint();
    }
    @Then("I received status 404 not found")
    public void receivedStatus404(){
        updateComplaintDiscussionByID.receivedStatus404();
    }
    @Given("I set with valid method and an invalid API endpoint ID")
    public void setWithValidMethodAndAnInvalidApiEndpointId(){
        updateComplaintDiscussionByID.setWithValidMethodAndAnInvalidApiEndpointId();
    }
    @Then("I send a request to update complaint discussion by ID with invalid ID")
    public void sendARequestToUpdateComplaintDiscussionByIdWithInvalidId(){
        updateComplaintDiscussionByID.sendARequestToUpdateComplaintDiscussionByIdWithInvalidId();
    }
    @And("I received 404 not found")
    public void received404(){
        updateComplaintDiscussionByID.received404();
    }
}
