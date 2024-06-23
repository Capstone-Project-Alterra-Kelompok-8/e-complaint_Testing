package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import starter.user.StatusCode;

public class StatusCodeSteps {
    @Steps
    StatusCode statusCode;

    @Then("I receive status code 200 OK response")
    public void receiveStatusCode200(){
        statusCode.receiveStatusCode200();
    }

    @Then("I receive status code 201 Created")
    public void receiveStatusCode201(){
        statusCode.receiveStatusCode201();
    }

    @Then("I receive status code 404 Not Found response")
    public void receiveStatusCode404(){
        statusCode.receiveStatusCode404();
    }

    @Then("I receive status code 400 Bad Request")
    public void receiveStatusCode400(){
        statusCode.receiveStatusCode400();
    }

    @Then("I receive status code 401 Unauthorized")
    public void ReceiveStatusCode401() {statusCode.receiveStatusCode401();}
}