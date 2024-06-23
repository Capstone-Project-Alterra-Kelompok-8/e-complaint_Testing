package starter.stepdefinitions.newsComment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.newsComment.CreateNewsCommentById;

public class CreateNewsCommentByIdSteps {
    @Steps
    CreateNewsCommentById createNewsCommentById;

    @Given("I set a valid endpoint and method")
    public void setAValidEndpointAndMethod(){
        createNewsCommentById.setAValidEndpointAndMethod();
    }
    @When("I send a request to create news comment by ID")
    public void sendARequestToCreateNewsCommentById(){
        createNewsCommentById.sendARequestToCreateNewsCommentById();
    }
    @Then("I received on status code 201 created")
    public void receivedOnStatusCode201(){
        createNewsCommentById.receivedOnStatusCode201();
    }
    @And("I create news comment with valid")
    public void createNewsCommentWithValid(){
        createNewsCommentById.createNewsCommentWithValid();
    }
    @Given("I set a valid API endpoint and incorrect method")
    public void setAValidApiEndpointAndIncorrectMethod(){
        createNewsCommentById.setAValidApiEndpointAndIncorrectMethod();
    }
    @When("I send request to create news comment by ID with invalid method")
    public void sendRequestToCreateNewsCommentByIdWithInvalidMethod(){
        createNewsCommentById.sendRequestToCreateNewsCommentByIdWithInvalidMethod();
    }
    @Then("I received on 404 not found status code")
    public void receivedOn404StatusCode(){
        createNewsCommentById.receivedOn404StatusCode();
    }
    @Given("I set the valid method and an incorrect API endpoint")
    public void setTheValidMethodAndAnIncorrectApiEndpoint(){
        createNewsCommentById.setTheValidMethodAndAnIncorrectApiEndpoint();
    }
    @When("I send request to create news comment by ID with invalid endpoint")
    public void sendRequestToCreateNewsCommentByIdWithInvalidEndpoint(){
        createNewsCommentById.sendRequestToCreateNewsCommentByIdWithInvalidEndpoint();
    }
    @Then("I received code 404 not found")
    public void receivedCode404(){
        createNewsCommentById.receivedCode404();
    }
    @Given("I set valid method and an invalid API endpoint ID")
    public void setValidMethodAndAnInvalidApiEndpointId(){
        createNewsCommentById.setValidMethodAndAnInvalidApiEndpointId();
    }
    @When("I send a request to create news comment by ID with invalid ID")
    public void sendARequestToCreateNewsCommentByIdWithInvalidId(){
        createNewsCommentById.sendARequestToCreateNewsCommentByIdWithInvalidId();
    }
    @Then("I received code 400 bad request")
    public void receivedCode400(){
        createNewsCommentById.receivedCode400();
    }
}
