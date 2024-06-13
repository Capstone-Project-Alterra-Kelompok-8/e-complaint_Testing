package starter.stepdefinitions.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.news.DeleteNewsByID;


public class DeleteNewsByIDSteps {

    @Steps
    DeleteNewsByID deleteNewsByID;

    @Given("I set valid endpoint and method")
    public void setValidEndpointAndMethod(){
        deleteNewsByID.setValidEndpointAndMethod();
    }
    @When("I send a request to delete news data by ID")
    public void sendARequestToDeleteNewsDataById(){
        deleteNewsByID.sendARequestToDeleteNewsDataById();
    }
    @Then("I receive in status code 200 OK")
    public void receiveInStatusCode200(){
        deleteNewsByID.receiveInStatusCode200();
    }
    @And("I see news data has been delete with valid")
    public void seeNewsDataHasBeenDeleteWithValid(){
        deleteNewsByID.seeNewsDataHasBeenDeleteWithValid();
    }
    @Given("I set valid API endpoint with wrong method")
    public void setValidApiEndpointWithWrongMethod(){
        deleteNewsByID.setValidApiEndpointWithWrongMethod();
    }
    @When("I send a request to delete news data by ID with invalid method")
    public void sendARequestToDeleteNewsDataByIdWithInvalidMethod(){
        deleteNewsByID.sendARequestToDeleteNewsDataByIdWithInvalidMethod();
    }
    @Then("I receive status code 404 not found")
    public void receiveStatusCode404(){
        deleteNewsByID.receiveStatusCode404();
    }
    @Given("I set valid method and wrong endpoint")
    public void setValidMethodAndWrongEndpoint(){
        deleteNewsByID.setValidMethodAndWrongEndpoint();
    }
    @When("I send request to delete news data by ID with invalid endpoint")
    public void sendRequestToDeleteNewsDataByIdWithInvalidEndpoint(){
        deleteNewsByID.sendRequestToDeleteNewsDataByIdWithInvalidEndpoint();
    }
    @Then("I received in status code 404 not found")
    public void receivedInStatusCode404(){
        deleteNewsByID.receivedInStatusCode404();
    }
    @Given("I set with valid method and invalid API endpoint ID")
    public void setWithValidMethodAndInvalidApiEndpointId(){
        deleteNewsByID.setWithValidMethodAndInvalidApiEndpointId();
    }
    @Then("I send a request to delete news data by ID with invalid ID")
    public void sendARequestToDeleteNewsDataByIdWithInvalidId(){
        deleteNewsByID.sendARequestToDeleteNewsDataByIdWithInvalidId();
    }
    @And("I received status code 400 bad request")
    public void receivedStatusCode400(){
        deleteNewsByID.receivedStatusCode400();
    }
}
