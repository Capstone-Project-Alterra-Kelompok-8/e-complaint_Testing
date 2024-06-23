package starter.stepdefinitions.Complaint_Processes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaint_Processes.CreateComplaintProcess;

public class CreateComplaintProcessSteps {
    @Steps
    CreateComplaintProcess createComplaintProcess;

    @Given("I set API endpoint for create a complaint process")
    public void setApiNewComplaintProcess(){
        createComplaintProcess.setApiForNewComplaintProcess();
    }

    @When("I send request endpoint for create a complaint process with valid credentials")
    public void sendRequestNewComplaintProcess(){
        createComplaintProcess.sendCreateComplaintProcessRequest();
    }

    @And("I receive valid data for complaint process")
    public void receiveNewComplaintProcess(){
        createComplaintProcess.receiveValidDataForCreateNewComplaintProcess();
    }

    @When("I send request endpoint for create a complaint process with invalid status")
    public void sendRequestInvalidNewComplaintProcess(){
        createComplaintProcess.sendInvalidCreateComplaintProcessRequest();
    }

    @And("I receive error message that invalid status")
    public void receiveInvalidStatusMessage(){
        createComplaintProcess.receiveInValidDataForCreateNewComplaintProcess();
    }
}
