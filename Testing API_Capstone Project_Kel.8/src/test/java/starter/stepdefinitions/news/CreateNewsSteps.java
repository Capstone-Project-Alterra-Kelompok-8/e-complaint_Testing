package starter.stepdefinitions.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.news.CreateNews;

public class CreateNewsSteps {
    @Steps
    CreateNews createNews;

    @Given("I set the valid endpoint and method")
    public void setTheValidEndpointAndMethod(){
        createNews.setTheValidEndpointAndMethod();
    }
    @When("I send a request to create news data")
    public void sendARequestToCreateNewsData(){
        createNews.sendARequestToCreateNewsData();
    }
    @Then("I received a status code 201 created")
    public void receivedAStatusCode201(){
        createNews.receivedAStatusCode201();
    }
    @And("I create news data with valid")
    public void createNewsDataWithValid(){
        createNews.createNewsDataWithValid();
    }
    @Given("I set valid endpoint and incorrect method")
    public void setValidEndpointAndIncorrectMethod(){
        createNews.setValidEndpointAndIncorrectMethod();
    }
    @When("I send request to create news data with invalid method")
    public void sendRequestToCreateNewsDataWithInvalidMethod(){
        createNews.sendRequestToCreateNewsDataWithInvalidMethod();
    }
    @Then("I received 404 not found status code")
    public void received404StatusCode(){
        createNews.received404StatusCode();
    }
    @Given("I set valid method and an incorrect API endpoint")
    public void setValidMethodAndAnIncorrectApiEndpoint(){
        createNews.setValidMethodAndAnIncorrectApiEndpoint();
    }
    @When("I send request to create news data with invalid endpoint")
    public void sendRequestToCreateNewsDataWithInvalidEndpoint(){
        createNews.sendRequestToCreateNewsDataWithInvalidEndpoint();
    }
    @Then("I receive in status 404 not found")
    public void receiveInStatusCode404(){
        createNews.receiveInStatusCode404();
    }
//    @Given("I set valid method and invalid category ID")
//    public void setValidMethodAndInvalidCategoryId(){
//        createNews.setValidMethodAndInvalidCategoryId();
//    }
//    @When("I send a request to create news with invalid ID")
//    public void sendARequestToCreateNewsWithInvalidId(){
//        createNews.sendARequestToCreateNewsWithInvalidId();
//    }
//    @Then("I see status 404 not found")
//    public void seeStatus404(){
//        createNews.seeStatus404();
//    }
}
