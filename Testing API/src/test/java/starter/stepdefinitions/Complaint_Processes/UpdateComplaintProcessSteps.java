package starter.stepdefinitions.Complaint_Processes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaint_Processes.UpdateComplaintProcess;

public class UpdateComplaintProcessSteps {
    @Steps
    UpdateComplaintProcess updateComplaintProcess;

    @Given("I set API endpoint for update complaint process")
    public void setApiGetEndValidUpdateComplaintProcess(){
        updateComplaintProcess.setApiUpdateComplaintProcess();
    }

    @When("I send request to update complaint process by valid credentials")
    public void sendGetRequestValidUpdateComplaintProcess(){
        updateComplaintProcess.sendPutRequestUpdateComplaintProcess();
    }

    @And("I should get data complaint process that I updated")
    public void ReceiveDataComplaintProcessUpdated(){
        updateComplaintProcess.receiveComplaintProcessDataUpdated();
    }

    @When("I send request to update complaint process by blank field")
    public void sendGetRequestBlankFieldUpdateComplaintProcess(){
        updateComplaintProcess.sendPutBlankFieldRequestUpdateComplaintProcess();
    }
}
