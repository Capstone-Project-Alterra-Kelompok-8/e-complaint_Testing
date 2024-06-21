package starter.stepdefinitions.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.news.DeleteNewsById;


public class DeleteNewsByIDSteps {

    @Steps
    DeleteNewsById deleteNewsByID;

    @Given("I set valid endpoint and method")
    public void setValidEndpointAndMethod(){
        deleteNewsByID.setValidEndpointAndMethod();
    }
    @When("I send a request to delete news by ID")
    public void sendARequestToDeleteNewsById(){
        deleteNewsByID.sendARequestToDeleteNewsById();
    }
    @Then("I receive in status code 200 OK")
    public void receiveInStatusCode200(){
        deleteNewsByID.receiveInStatusCode200();
    }
    @And("I see news has been delete with valid")
    public void seeNewsHasBeenDeleteWithValid(){
        deleteNewsByID.seeNewsHasBeenDeleteWithValid();
    }
    @Given("I set valid API endpoint with wrong method")
    public void setValidApiEndpointWithWrongMethod(){
        deleteNewsByID.setValidApiEndpointWithWrongMethod();
    }
    @When("I send a request to delete news by ID with invalid method")
    public void sendARequestToDeleteNewsByIdWithInvalidMethod(){
        deleteNewsByID.sendARequestToDeleteNewsByIdWithInvalidMethod();
    }
    @Then("I receive status code 404 not found")
    public void receiveStatusCode404(){
        deleteNewsByID.receiveStatusCode404();
    }
    @Given("I set valid method and wrong endpoint")
    public void setValidMethodAndWrongEndpoint(){
        deleteNewsByID.setValidMethodAndWrongEndpoint();
    }
    @When("I send request to delete news by ID with invalid endpoint")
    public void sendRequestToDeleteNewsByIdWithInvalidEndpoint(){
        deleteNewsByID.sendRequestToDeleteNewsByIdWithInvalidEndpoint();
    }
    @Then("I received in status code 404 not found")
    public void receivedInStatusCode404(){
        deleteNewsByID.receivedInStatusCode404();
    }
    @Given("I set with valid method and invalid API endpoint ID")
    public void setWithValidMethodAndInvalidApiEndpointId(){
        deleteNewsByID.setWithValidMethodAndInvalidApiEndpointId();
    }
    @Then("I send a request to delete news by ID with invalid ID")
    public void sendARequestToDeleteNewsByIdWithInvalidId(){
        deleteNewsByID.sendARequestToDeleteNewsByIdWithInvalidId();
    }
    @And("I get code 404 not found")
    public void getCode404(){
        deleteNewsByID.getCode404();
    }
}
