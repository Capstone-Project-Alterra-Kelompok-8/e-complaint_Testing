package starter.stepdefinitions.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.news.GetAllNews;

public class GetAllNewsSteps {
    @Steps
    GetAllNews getAllNews;

    @Given("I set valid API endpoint and method")
    public void setValidApiEndpointAndMethod(){
        getAllNews.setValidApiEndpointAndMethod();
    }
    @When("I send a request to get all news data")
    public void sendARequestToGetAllNewsData(){
        getAllNews.sendARequestToGetAllNewsData();
    }
    @Then("I receive the status code 200 OK")
    public void receiveTheStatusCode200(){
        getAllNews.receiveTheStatusCode200();
    }
    @And("I get all news data with valid")
    public void getAllNewsDataWithValid(){
        getAllNews.getAllNewsDataWithValid();
    }
    @Given("I set valid API endpoint and wrong method")
    public void setValidApiEndpointAndWrongMethod(){
        getAllNews.setValidApiEndpointAndWrongMethod();
    }
    @When("I send request to get all news data with invalid method")
    public void sendRequestToGetAllNewsDataWithInvalidMethod(){
        getAllNews.sendRequestToGetAllNewsDataWithInvalidMethod();
    }
    @Then("I receive the status code 404 not found")
    public void receiveTheStatusCode404(){
        getAllNews.receiveTheStatusCode404();
    }
    @Given("I set valid method and wrong API endpoint")
    public void setValidMethodAndWrongApiEndpoint(){
        getAllNews.setValidMethodAndWrongApiEndpoint();
    }
    @When("I send request to get all news data with invalid endpoint")
    public void sendRequestToGetAllNewsDataWithInvalidEndpoint(){
        getAllNews.sendRequestToGetAllNewsDataWithInvalidEndpoint();
    }
    @Then("I receive in status code 404 not found")
    public void receiveInStatusCode404(){
        getAllNews.receiveInStatusCode404();
    }
}
