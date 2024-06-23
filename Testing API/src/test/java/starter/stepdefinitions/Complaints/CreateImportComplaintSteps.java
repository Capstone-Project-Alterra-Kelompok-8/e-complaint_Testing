package starter.stepdefinitions.Complaints;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaints.CreateImportComplaint;

public class CreateImportComplaintSteps {
    @Steps
    CreateImportComplaint createImportComplaint;

    @Given("I set API endpoint for create new import complaint")
    public void setApiImportComplaint(){
        createImportComplaint.setApiNewImportComplaint();
    }

    @When("I send request endpoint for create new import complaint")
    public void sendRequestImportComplaint(){
        createImportComplaint.sendCreateImportComplaint();
    }

    @And("I receive valid status for import complaints was success")
    public void receiveStatusImportComplaintData(){
        createImportComplaint.receiveStatusDataForNewImportComplaint();
    }
}
