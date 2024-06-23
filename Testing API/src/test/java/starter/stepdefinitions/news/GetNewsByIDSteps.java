package starter.stepdefinitions.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.news.GetNewsById;

public class GetNewsByIDSteps {

    @Steps
    GetNewsById getNewsByID;

    @Given("I set API endpoint and method with valid")
    public void setApiEndpointAndMethodWithValid(){
        getNewsByID.setApiEndpointAndMethodWithValid();
    }
    @When("I send a request to get news data by ID")
    public void sendARequestToGetNewsById(){
        getNewsByID.sendARequestToGetNewsById();
    }
    @Then("I get status code 200 OK")
    public void getStatusCode200(){
        getNewsByID.getStatusCode200();
    }
    @And("I get news data by ID with valid")
    public void getNewsDataByIdWithValid(){
        getNewsByID.getNewsDataByIdWithValid();
    }
    @Given("I set with valid API endpoint and wrong method")
    public void setWithValidApiEndpointAndWrongMethod(){
        getNewsByID.setWithValidApiEndpointAndWrongMethod();
    }
    @When("I send request to get news data by ID with invalid method")
    public void sendRequestToGetNewsDataByIdWithInvalidMethod(){
        getNewsByID.sendRequestToGetNewsDataByIdWithInvalidMethod();
    }
    @Then("I received the status code 404 not found")
    public void receivedTheStatusCode404(){
        getNewsByID.receivedTheStatusCode404();
    }
    @Given("I set with valid method and wrong API endpoint")
    public void setWithValidMethodAndWrongApiEndpoint(){
        getNewsByID.setWithValidMethodAndWrongApiEndpoint();
    }
    @When("I send request to get news data by ID with invalid endpoint")
    public void sendRequestToGetNewsDataByIdWithInvalidEndpoint(){
        getNewsByID.sendRequestToGetNewsDataByIdWithInvalidEndpoint();
    }
    @Then("I get status code 404 not found")
    public void getStatusCode404(){
        getNewsByID.getStatusCode404();
    }
    @Given("I set with valid method and invalid ID API endpoint")
    public void setWithValidMethodAndInvalidIdApiEndpoint(){
        getNewsByID.setWithValidMethodAndInvalidIdApiEndpoint();
    }
    @Then("I send request to get news data by ID with invalid ID")
    public void sendRequestToGetNewsDataByIdWithInvalidId(){
        getNewsByID.sendRequestToGetNewsDataByIdWithInvalidId();
    }
    @And("I see status code 404 not found")
    public void seeStatusCode404(){
        getNewsByID.seeStatusCode404();
    }
}
