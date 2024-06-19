package starter.stepdefinitions.Complaint_Processes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaint_Processes.GetComplaintProcess;

public class GetComplaintProcessSteps {
    @Steps
    GetComplaintProcess getComplaintProcess;

    @Given("I set API endpoint with an valid ID to get complaint process by valid ID")
    public void setApiGetEndValidIDComplaintProcess(){
        getComplaintProcess.setApiGetEndValidComplaintProcessID();
    }

    @When("I send request endpoint for get complaint process by ID")
    public void sendGetRequestValidIDComplaintProcess(){
        getComplaintProcess.sendGetRequestValidComplaintProcessID();
    }

    @And("I receive complaint process information based on id by valid ID")
    public void receiveDetailsValidIDComplaintProcess(){
        getComplaintProcess.receiveValidComplaintProcessID();
    }

    @Given("I set API endpoint with an valid ID to get complaint process by invalid ID")
    public void setApiGetEndInValidIDComplaintProcess(){
        getComplaintProcess.setApiGetEndInValidComplaintProcessID();
    }
    @When("I send request endpoint for get complaint process by invalid ID")
    public void sendGetRequestInValidIDComplaintProcess(){
        getComplaintProcess.sendGetRequestInValidComplaintProcessID();
    }
}
