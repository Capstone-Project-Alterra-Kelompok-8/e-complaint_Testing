package starter.stepdefinitions.newsComment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.newsComment.UpdateNewsCommentById;

public class UpdateNewsCommentByIdSteps {

    @Steps
    UpdateNewsCommentById updateNewsCommentById;

    @Given("I set valid endpoint and method with valid")
    public void setValidEndpointAndMethodWithValid(){
        updateNewsCommentById.setValidEndpointAndMethodWithValid();
    }
    @When("I send a request to update news comment by ID")
    public void sendARequestToUpdateNewsCommentById(){
        updateNewsCommentById.sendARequestToUpdateNewsCommentById();
    }
    @Then("I received status 200 OK")
    public void receivedStatus200(){
        updateNewsCommentById.receivedStatus200();
    }
    @And("I see news comment has been update with valid")
    public void seeNewsCommentHasBeenUpdateWithValid(){
        updateNewsCommentById.seeNewsCommentHasBeenUpdateWithValid();
    }
    @Given("I set valid endpoint with the wrong method")
    public void setValidEndpointWithTheWrongMethod(){
        updateNewsCommentById.setValidEndpointWithTheWrongMethod();
    }
    @When("I send a request to update news comment by ID with invalid method")
    public void sendARequestToUpdateNewsCommentByIdWithInvalidMethod(){
        updateNewsCommentById.sendARequestToUpdateNewsCommentByIdWithInvalidMethod();
    }
    @Then("I get status 404 not found")
    public void getStatus404(){
        updateNewsCommentById.getStatus404();
    }
    @Given("I set valid method and an incorrect endpoint")
    public void setValidMethodAndAnIncorrectEndpoint(){
        updateNewsCommentById.setValidMethodAndAnIncorrectEndpoint();
    }
    @When("I send request to update news comment by ID with invalid endpoint")
    public void sendRequestToUpdateNewsCommentByIdWithInvalidEndpoint(){
        updateNewsCommentById.sendRequestToUpdateNewsCommentByIdWithInvalidEndpoint();
    }
    @Then("I get status in 404 not found")
    public void getStatusIn404(){
        updateNewsCommentById.getStatusIn404();
    }
    @Given("I set valid method and invalid API endpoint ID")
    public void setValidMethodAndInvalidApiEndpointId(){
        updateNewsCommentById.setValidMethodAndInvalidApiEndpointId();
    }
    @Then("I send a request to update news comment by ID with invalid ID")
    public void sendARequestToUpdateNewsCommentByIdWithInvalidId(){
        updateNewsCommentById.sendARequestToUpdateNewsCommentByIdWithInvalidId();
    }
    @And("I received 400 bad request")
    public void received400(){
        updateNewsCommentById.received400();
    }
}
