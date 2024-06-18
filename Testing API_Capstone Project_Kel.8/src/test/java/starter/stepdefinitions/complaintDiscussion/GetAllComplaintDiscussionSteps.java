package starter.stepdefinitions.complaintDiscussion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.complaintDiscussion.GetAllComplaintDiscussion;

public class GetAllComplaintDiscussionSteps {
    @Steps
    GetAllComplaintDiscussion getAllComplaintDiscussion;

    @Given("I set the valid API endpoint and method")
    public void setTheValidApiEndpointAndMethod(){
        getAllComplaintDiscussion.setTheValidApiEndpointAndMethod();
    }
    @When("I send a request to get all complaint discussion")
    public void sendARequestToGetAllComplaintDiscussion(){
        getAllComplaintDiscussion.sendARequestToGetAllComplaintDiscussion();
    }
    @Then("I receive status code 200 OK")
    public void receiveStatusCode200(){
        getAllComplaintDiscussion.receiveStatusCode200();
    }
    @And("I get all complaint discussion with valid")
    public void getAllComplaintDiscussionWithValid(){
        getAllComplaintDiscussion.getAllComplaintDiscussionWithValid();
    }
    @Given("I set the valid API endpoint and incorrect method")
    public void setTheValidApiEndpointAndIncorrectMethod(){
        getAllComplaintDiscussion.setTheValidApiEndpointAndIncorrectMethod();
    }
    @When("I send request to get all complaint discussion with invalid method")
    public void sendRequestToGetAllComplaintDiscussionWithInvalidMethod(){
        getAllComplaintDiscussion.sendRequestToGetAllComplaintDiscussionWithInvalidMethod();
    }
    @Then("I receive a 404 not found status code")
    public void receiveA404StatusCode(){
        getAllComplaintDiscussion.receiveA404StatusCode();
    }
    @Given("I set a valid method and an incorrect API endpoint")
    public void setAValidMethodAndAnIncorrectApiEndpoint(){
        getAllComplaintDiscussion.setAValidMethodAndAnIncorrectApiEndpoint();
    }
    @When("I send request to get all complaint discussion with invalid endpoint")
    public void sendRequestToGetAllComplaintDiscussionWithInvalidEndpoint(){
        getAllComplaintDiscussion.sendRequestToGetAllComplaintDiscussionWithInvalidEndpoint();
    }
    @Then("I receive a status code 404 not found")
    public void receiveAStatusCode404(){
        getAllComplaintDiscussion.receiveAStatusCode404();
    }
}
