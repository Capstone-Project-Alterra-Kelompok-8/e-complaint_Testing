package starter.stepdefinitions.complaintDiscussion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;


public class DeleteComplaintDiscussionByIdSteps {

    @Steps
    starter.api.complaintDiscussion.DeleteComplaintDiscussionById deleteComplaintDiscussionByID;

    @Given("I set a valid API endpoint and method")
    public void setAValidApiEndpointAndMethod(){
        deleteComplaintDiscussionByID.setAValidApiEndpointAndMethod();
    }
    @When("I send a request to delete complaint discussion data by ID")
    public void sendARequestToDeleteComplaintDiscussionDataById(){
        deleteComplaintDiscussionByID.sendARequestToDeleteComplaintDiscussionDataById();
    }
    @Then("I receive a status code 200 OK")
    public void receiveAStatusCode200(){
        deleteComplaintDiscussionByID.receiveAStatusCode200();
    }
    @And("I see complaint discussion data has been delete with valid")
    public void seeComplaintDiscussionDataHasBeenDeleteWithValid(){
        deleteComplaintDiscussionByID.seeComplaintDiscussionDataHasBeenDeleteWithValid();
    }
    @Given("I set a valid API endpoint with the wrong method")
    public void setAValidApiEndpointWithTheWrongMethod(){
        deleteComplaintDiscussionByID.setAValidApiEndpointWithTheWrongMethod();
    }
    @When("I send a request to delete complaint discussion data by ID with invalid method")
    public void sendARequestToDeleteComplaintDiscussionDataByIdWithInvalidMethod(){
        deleteComplaintDiscussionByID.sendARequestToDeleteComplaintDiscussionDataByIdWithInvalidMethod();
    }
    @Then("I receive on status code 404 not found")
    public void receiveOnStatusCode404(){
        deleteComplaintDiscussionByID.receiveOnStatusCode404();
    }
    @Given("I set a valid method and an incorrect endpoint")
    public void setAValidMethodAndAnIncorrectEndpoint(){
        deleteComplaintDiscussionByID.setAValidMethodAndAnIncorrectEndpoint();
    }
    @When("I send request to delete complaint discussion data by ID with invalid endpoint")
    public void sendRequestToDeleteComplaintDiscussionDataByIdWithInvalidEndpoint(){
        deleteComplaintDiscussionByID.sendRequestToDeleteComplaintDiscussionDataByIdWithInvalidEndpoint();
    }
    @Then("I received a status code 404 not found")
    public void receivedAStatusCode404(){
        deleteComplaintDiscussionByID.receivedAStatusCode404();
    }
    @Given("I set a valid method and an invalid API endpoint ID")
    public void setAValidMethodAndAnInvalidApiEndpointId(){
        deleteComplaintDiscussionByID.setAValidMethodAndAnInvalidApiEndpointId();
    }
    @Then("I send a request to delete complaint discussion data by ID with invalid ID")
    public void sendARequestToDeleteComplaintDiscussionDataByIdWithInvalidId(){
        deleteComplaintDiscussionByID.sendARequestToDeleteComplaintDiscussionDataByIdWithInvalidId();
    }
    @And("I received status code 404 not found")
    public void receivedStatusCode404(){
        deleteComplaintDiscussionByID.receivedStatusCode404();
    }
}
