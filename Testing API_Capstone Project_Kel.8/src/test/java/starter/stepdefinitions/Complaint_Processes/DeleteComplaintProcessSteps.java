package starter.stepdefinitions.Complaint_Processes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaint_Processes.DeleteComplaintProcess;

public class DeleteComplaintProcessSteps {
    @Steps
    DeleteComplaintProcess deleteComplaintProcess;

    @Given("I set API endpoint for delete complaint process with valid ID")
    public void setDeleteValidComplaintProcess(){
        deleteComplaintProcess.setApiDeleteComplaintProcessEndpoint();
    }

    @When("I send request endpoint for delete complaint process")
    public void sendDeleteComplaintProcessRequest(){
        deleteComplaintProcess.sendDeleteComplaintProcessUserRequest();
    }

    @And("I receive response body that complaint process deleted")
    public void receiveDeleteComplaintProcessResponse(){
        deleteComplaintProcess.receiveComplaintProcessResponseBody();
    }

    @Given("I set API endpoint for delete complaint process with invalid ID")
    public void setDeleteInValidComplaintProcess(){
        deleteComplaintProcess.setApiInvalidDeleteComplaintProcessEndpoint();
    }
    @And("I receive response body that complaint process not found")
    public void receiveErrorMessageComplaintprocessNotFound(){
        deleteComplaintProcess.receiveErrorMessageComplaintProcessNotFounds();
    }
    @When("I send request endpoint for delete complaint process with invalid ID")
    public void sendDeleteInvalidComplaintProcessRequest(){
        deleteComplaintProcess.sendDeleteInvalidComplaintProcessUserRequest();
    }
}
