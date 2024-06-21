package starter.stepdefinitions.newsComment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.newsComment.GetNewsCommentById;

public class GetNewsCommentByIdSteps {

    @Steps
    GetNewsCommentById getNewsCommentById;

    @Given("I set a API endpoint and method with valid")
    public void setAApiEndpointAndMethodWithValid(){
        getNewsCommentById.setAApiEndpointAndMethodWithValid();
    }
    @When("I send a request to get news comment by ID")
    public void sendARequestToGetNewsCommentById(){
        getNewsCommentById.sendARequestToGetNewsCommentById();
    }
    @Then("I get the status code 200 OK")
    public void getTheStatusCode200(){
        getNewsCommentById.getTheStatusCode200();
    }
    @And("I get news comment by ID with valid")
    public void getNewsCommentByIdWithValid(){
        getNewsCommentById.getNewsCommentByIdWithValid();
    }
    @Given("I set with a valid API endpoint and wrong method")
    public void setWithAValidApiEndpointAndWrongMethod(){
        getNewsCommentById.setWithAValidApiEndpointAndWrongMethod();
    }
    @When("I send request to get news comment by ID with invalid method")
    public void sendRequestToGetNewsCommentByIdWithInvalidMethod(){
        getNewsCommentById.sendRequestToGetNewsCommentByIdWithInvalidMethod();
    }
    @Then("I get a status code 404 not found")
    public void getAStatusCode404(){
        getNewsCommentById.getAStatusCode404();
    }
    @Given("I set with a valid method and wrong API endpoint")
    public void setWithAValidMethodAndWrongApiEndpoint(){
        getNewsCommentById.setWithAValidMethodAndWrongApiEndpoint();
    }
    @When("I send request to get news comment by ID with invalid endpoint")
    public void sendRequestToGetNewsCommentByIdWithInvalidEndpoint(){
        getNewsCommentById.sendRequestToGetNewsCommentByIdWithInvalidEndpoint();
    }
    @Then("I get on status code 404 not found")
    public void getOnStatusCode404(){
        getNewsCommentById.getOnStatusCode404();
    }
    @Given("I set with a valid method and invalid ID API endpoint")
    public void setWithAValidMethodAndInvalidIdApiEndpoint(){
        getNewsCommentById.setWithAValidMethodAndInvalidIdApiEndpoint();
    }
    @Then("I send request to get news comment by ID with invalid ID")
    public void sendRequestToGetNewsCommentByIdWithInvalidId(){
        getNewsCommentById.sendRequestToGetNewsCommentByIdWithInvalidId();
    }
    @And("I get on status code 400 bad request")
    public void getOnStatusCode400(){
        getNewsCommentById.getOnStatusCode400();
    }
}
