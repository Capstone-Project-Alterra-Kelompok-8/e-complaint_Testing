package starter.stepdefinitions;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import starter.user.ErrorMessage;

public class ErrorMessageSteps {
    @Steps
    ErrorMessage errorMessage;

    @And("I received an error message that all fields must be filled in")
    public void receiveErrorMessageFieldsBlank(){
        errorMessage.receiveErrorMessageFieldBlanks();
    }
    @And("I receive error message that not found")
    public void receiveErrorMessageNotFound(){
        errorMessage.receiveErrorMessageNotFounds();
    }

    @And("I receive response body that complaint not found")
    public void receiveErrorMessageComplaintNotFound(){
        errorMessage.receiveErrorMessageComplaintNotFounds();
    }

    @And("I receive error message that category not found")
    public void receiveErrorMessageComplaintData(){
        errorMessage.receiveInValidDataForNewComplaint();
    }
}
