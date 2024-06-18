package starter.stepdefinitions.newsComment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.newsComment.DeleteNewsCommentById;

public class DeleteNewsCommentByIdSteps {

    @Steps
    DeleteNewsCommentById deleteNewsCommentById;

    @Given("I set with valid endpoint and method")
    public void setWithValidEndpointAndMethod(){
        deleteNewsCommentById.setWithValidEndpointAndMethod();
    }
    @When("I send a request to delete news comment by ID")
    public void sendARequestToDeleteNewsCommentById(){
        deleteNewsCommentById.sendARequestToDeleteNewsCommentById();
    }
    @Then("I received status code 200 OK")
    public void receivedStatusCode200(){
        deleteNewsCommentById.receivedStatusCode200();
    }
    @And("I see news comment has been delete with valid")
    public void seeNewsCommentHasBeenDeleteWithValid(){
        deleteNewsCommentById.seeNewsCommentHasBeenDeleteWithValid();
    }
    @Given("I set with valid API endpoint with wrong method")
    public void setWithValidApiEndpointWithWrongMethod(){
        deleteNewsCommentById.setWithValidApiEndpointWithWrongMethod();
    }
    @When("I send a request to delete news comment by ID with invalid method")
    public void sendARequestToDeleteNewsCommentByIdWithInvalidMethod(){
        deleteNewsCommentById.sendARequestToDeleteNewsCommentByIdWithInvalidMethod();
    }
    @Then("I get in status code 404 not found")
    public void getInStatusCode404(){
        deleteNewsCommentById.getInStatusCode404();
    }
    @Given("I set with valid method and wrong endpoint")
    public void setWithValidMethodAndWrongEndpoint(){
        deleteNewsCommentById.setWithValidMethodAndWrongEndpoint();
    }
    @When("I send request to delete news comment by ID with invalid endpoint")
    public void sendRequestToDeleteNewsCommentByIdWithInvalidEndpoint(){
        deleteNewsCommentById.sendRequestToDeleteNewsCommentByIdWithInvalidEndpoint();
    }
    @Then("I received on status code 404 not found")
    public void receivedOnStatusCode404(){
        deleteNewsCommentById.receivedOnStatusCode404();
    }
    @Given("I set with valid method and invalid endpoint ID")
    public void setWithValidMethodAndInvalidEndpointId(){
        deleteNewsCommentById.setWithValidMethodAndInvalidEndpointId();
    }
    @Then("I send a request to delete news comment by ID with invalid ID")
    public void sendARequestToDeleteNewsCommentByIdWithInvalidId(){
        deleteNewsCommentById.sendARequestToDeleteNewsCommentByIdWithInvalidId();
    }
    @And("I received a status code 400 bad request")
    public void receivedAStatusCode400(){
        deleteNewsCommentById.receivedAStatusCode400();
    }
}
