package starter.stepdefinitions.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Users.DeleteUser;

public class DeleteUserSteps {
    @Steps
    DeleteUser deleteUser;

    @Given("I set API endpoint for delete user with valid ID")
    public void setDeleteValidUserSteps(){
        deleteUser.setApiDeleteUserEndpoint();
    }

    @When("I send request endpoint for delete user")
    public void sendDeleteUserRequest(){
        deleteUser.sendDeleteUserRequest();
    }

    @And("I receive response body for delete user")
    public void receiveDeleteUserResponse(){
        deleteUser.receiveUserResponseBody();
    }
}
