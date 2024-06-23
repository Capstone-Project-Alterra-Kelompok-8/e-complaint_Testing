package starter.stepdefinitions.complaintDiscussion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.complaintDiscussion.GetAllRecommendation;

public class GetAllRecommendationSteps {
    @Steps
    GetAllRecommendation getAllRecommendation;

    @Given("I set the API endpoint and method with valid")
    public void setTheApiEndpointAndMethodWithValid(){
        getAllRecommendation.setTheApiEndpointAndMethodWithValid();
    }
    @When("I send a request to get all recommendation")
    public void sendARequestToGetAllRecommendation(){
        getAllRecommendation.sendARequestToGetAllRecommendation();
    }
    @Then("I get a status code 200 OK")
    public void getAStatusCode200(){
        getAllRecommendation.getAStatusCode200();
    }
    @And("I get all recommendation with valid")
    public void getAllRecommendationWithValid(){
        getAllRecommendation.getAllRecommendationWithValid();
    }
    @Given("I set with valid API endpoint and incorrect method")
    public void setWithValidApiEndpointAndIncorrectMethod(){
        getAllRecommendation.setWithValidApiEndpointAndIncorrectMethod();
    }
    @When("I send request to get all recommendation with invalid method")
    public void sendRequestToGetAllRecommendationWithInvalidMethod(){
        getAllRecommendation.sendRequestToGetAllRecommendationWithInvalidMethod();
    }
    @Then("I get 404 not found status code")
    public void get404StatusCode(){
        getAllRecommendation.get404StatusCode();
    }
    @Given("I set with valid method and an incorrect API endpoint")
    public void setWithValidMethodAndAnIncorrectApiEndpoint(){
        getAllRecommendation.setWithValidMethodAndAnIncorrectApiEndpoint();
    }
    @When("I send request to get all recommendation with invalid endpoint")
    public void sendRequestToGetAllRecommendationWithInvalidEndpoint(){
        getAllRecommendation.sendRequestToGetAllRecommendationWithInvalidEndpoint();
    }
    @Then("I get the status code 404 not found")
    public void getTheStatusCode404(){
        getAllRecommendation.getTheStatusCode404();
    }
}
