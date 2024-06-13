package starter.stepdefinitions.Categories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Categories.UpdateCategory;

public class UpdateCategorySteps {
    @Steps
    UpdateCategory updateCategory;

    @Given("I set API endpoint for update category")
    public void setApiGetEndValidCategory(){
        updateCategory.setApiUpdateCategory();
    }

    @When("I send request to update category")
    public void sendGetRequestValidCategory(){
        updateCategory.sendPutRequestUpdateCategory();
    }

    @And("I should get data category that I updated")
    public void ReceiveDataCategoryUpdated(){
        updateCategory.receiveCategoryDataUpdated();
    }
}
