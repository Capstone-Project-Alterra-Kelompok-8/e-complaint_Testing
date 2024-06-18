package starter.stepdefinitions.complaintDiscussion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.complaintDiscussion.DeleteComplaintDiscussionById;


public class DeleteComplaintDiscussionByIdSteps {

    @Steps
    DeleteComplaintDiscussionById deleteComplaintDiscussionByID;

    @Given("I set a valid API endpoint and method")
    public void setAValidApiEndpointAndMethod(){
        deleteComplaintDiscussionByID.setAValidApiEndpointAndMethod();
    }
    @When("I send a request to delete complaint discussion by ID")
    public void sendARequestToDeleteComplaintDiscussionById(){
        deleteComplaintDiscussionByID.sendARequestToDeleteComplaintDiscussionById();
    }
    @Then("I receive a status code 200 OK")
    public void receiveAStatusCode200(){
        deleteComplaintDiscussionByID.receiveAStatusCode200();
    }
    @And("I see complaint discussion has been delete with valid")
    public void seeComplaintDiscussionHasBeenDeleteWithValid(){
        deleteComplaintDiscussionByID.seeComplaintDiscussionHasBeenDeleteWithValid();
    }
    @Given("I set a valid API endpoint with the wrong method")
    public void setAValidApiEndpointWithTheWrongMethod(){
        deleteComplaintDiscussionByID.setAValidApiEndpointWithTheWrongMethod();
    }
    @When("I send a request to delete complaint discussion by ID with invalid method")
    public void sendARequestToDeleteComplaintDiscussionByIdWithInvalidMethod(){
        deleteComplaintDiscussionByID.sendARequestToDeleteComplaintDiscussionByIdWithInvalidMethod();
    }
    @Then("I receive on status code 404 not found")
    public void receiveOnStatusCode404(){
        deleteComplaintDiscussionByID.receiveOnStatusCode404();
    }
    @Given("I set a valid method and an incorrect endpoint")
    public void setAValidMethodAndAnIncorrectEndpoint(){
        deleteComplaintDiscussionByID.setAValidMethodAndAnIncorrectEndpoint();
    }
    @When("I send request to delete complaint discussion by ID with invalid endpoint")
    public void sendRequestToDeleteComplaintDiscussionByIdWithInvalidEndpoint(){
        deleteComplaintDiscussionByID.sendRequestToDeleteComplaintDiscussionByIdWithInvalidEndpoint();
    }
    @Then("I received a status code 404 not found")
    public void receivedAStatusCode404(){
        deleteComplaintDiscussionByID.receivedAStatusCode404();
    }
    @Given("I set a valid method and an invalid API endpoint ID")
    public void setAValidMethodAndAnInvalidApiEndpointId(){
        deleteComplaintDiscussionByID.setAValidMethodAndAnInvalidApiEndpointId();
    }
    @Then("I send a request to delete complaint discussion by ID with invalid ID")
    public void sendARequestToDeleteComplaintDiscussionByIdWithInvalidId(){
        deleteComplaintDiscussionByID.sendARequestToDeleteComplaintDiscussionByIdWithInvalidId();
    }
    @And("I received status code 404 not found")
    public void receivedStatusCode404(){
        deleteComplaintDiscussionByID.receivedStatusCode404();
    }
}
