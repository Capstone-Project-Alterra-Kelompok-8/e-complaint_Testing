package starter.stepdefinitions.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.news.UpdateNewsById;

public class UpdateNewsByIdSteps {

    @Steps
    UpdateNewsById updateNewsById;

    @Given("I set valid endpoint and method with validly")
    public void setValidEndpointAndMethodWithValidly(){
        updateNewsById.setValidEndpointAndMethodWithValidly();
    }
    @When("I send a request to update news data by ID")
    public void sendARequestToUpdateNewsDataById(){
        updateNewsById.sendARequestToUpdateNewsDataById();
    }
    @Then("I see status 200 OK")
    public void seeStatus200(){
        updateNewsById.seeStatus200();
    }
    @And("I see news data has been update with valid")
    public void seeNewsDataHasBeenUpdateWithValid(){
        updateNewsById.seeNewsDataHasBeenUpdateWithValid();
    }
    @Given("I set with valid endpoint and wrong method")
    public void setWithValidEndpointAndWrongMethod(){
        updateNewsById.setWithValidEndpointAndWrongMethod();
    }
    @When("I send a request to update news data by ID with invalid method")
    public void sendARequestToUpdateNewsDataByIdWithInvalidMethod(){
        updateNewsById.sendARequestToUpdateNewsDataByIdWithInvalidMethod();
    }
    @Then("I see status 404 not found")
    public void seeStatus404(){
        updateNewsById.seeStatus404();
    }
    @Given("I set with valid method and incorrect endpoint")
    public void setWithValidMethodAndIncorrectEndpoint(){
        updateNewsById.setWithValidMethodAndIncorrectEndpoint();
    }
    @When("I send request to update news data by ID with invalid endpoint")
    public void sendRequestToUpdateNewsDataByIdWithInvalidEndpoint(){
        updateNewsById.sendRequestToUpdateNewsDataByIdWithInvalidEndpoint();
    }
    @Then("I see status in 404 not found")
    public void seeStatusIn404(){
        updateNewsById.seeStatusIn404();
    }
    @Given("I set valid method with invalid API endpoint ID")
    public void setValidMethodWithInvalidApiEndpointId(){
        updateNewsById.setValidMethodWithInvalidApiEndpointId();
    }
    @Then("I send a request to update news data by ID with invalid ID")
    public void sendARequestToUpdateNewsDataByIdWithInvalidId(){
        updateNewsById.sendARequestToUpdateNewsDataByIdWithInvalidId();
    }
    @And("I see 404 not found")
    public void see404(){
        updateNewsById.see404();
    }
}
