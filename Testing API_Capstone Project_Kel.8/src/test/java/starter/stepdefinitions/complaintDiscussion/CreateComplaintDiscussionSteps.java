package starter.stepdefinitions.complaintDiscussion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.complaintDiscussion.CreateComplaintDiscussion;

public class CreateComplaintDiscussionSteps {
    @Steps
    CreateComplaintDiscussion createComplaintDiscussions;

    @Given("I set on valid API endpoint and method")
    public void setOnValidApiEndpointAndMethod(){
        createComplaintDiscussions.setOnValidApiEndpointAndMethod();
    }
    @When("I send a request to create complaint discussion")
    public void sendARequestToCreateComplaintDiscussion(){
        createComplaintDiscussions.sendARequestToCreateComplaintDiscussion();
    }
    @Then("I receive on status code 201 created")
    public void receiveOnStatusCode201(){
        createComplaintDiscussions.receiveOnStatusCode201();
    }
    @And("I create complaint discussion with valid")
    public void createComplaintDiscussionWithValid(){
        createComplaintDiscussions.createComplaintDiscussionWithValid();
    }
    @Given("I set on valid API endpoint and incorrect method")
    public void setOnValidApiEndpointAndIncorrectMethod(){
        createComplaintDiscussions.setOnValidApiEndpointAndIncorrectMethod();
    }
    @When("I send request to create complaint discussion with invalid method")
    public void sendRequestToCreateComplaintDiscussionWithInvalidMethod(){
        createComplaintDiscussions.sendRequestToCreateComplaintDiscussionWithInvalidMethod();
    }
    @Then("I receive on 404 not found status code")
    public void receiveOn404StatusCode(){
        createComplaintDiscussions.receiveOn404StatusCode();
    }
    @Given("I set on valid method and an incorrect API endpoint")
    public void setOnValidMethodAndAnIncorrectApiEndpoint(){
        createComplaintDiscussions.setOnValidMethodAndAnIncorrectApiEndpoint();
    }
    @When("I send request to create complaint discussion with invalid endpoint")
    public void sendRequestToCreateComplaintDiscussionWithInvalidEndpoint(){
        createComplaintDiscussions.sendRequestToCreateComplaintDiscussionWithInvalidEndpoint();
    }
    @Then("I receive code 404 not found")
    public void receiveCode404(){
        createComplaintDiscussions.receiveCode404();
    }
}
