package starter.stepdefinitions.Categories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Categories.GetAllCategories;

public class GetAllCategoriesSteps {
    @Steps
    GetAllCategories getAllCategories;

    @Given("I set API endpoint for get all categories")
    public void setApiEndCategories(){
        getAllCategories.setApiEndGetAllCategories();
    }

    @When("I send request endpoint for get all categories")
    public void sendGetAllCategoriesRequest(){
        getAllCategories.sendRequestGetAllCategories();
    }

    @And("I receive data for all categories details")
    public void receiveValidCategories(){
        getAllCategories.receiveValidAllCategories();
    }
}
