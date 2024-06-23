package starter.stepdefinitions.Categories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Categories.DeleteCategory;

public class DeleteCategorySteps {
    @Steps
    DeleteCategory deleteCategory;

    @Given("I set API endpoint for delete category with valid ID")
    public void setDeleteValidCategory(){
        deleteCategory.setApiDeleteCategoryEndpoint();
    }

    @When("I send request endpoint for delete category")
    public void sendDeleteCategoryRequest(){
        deleteCategory.sendDeleteCategoryUserRequest();
    }

    @And("I receive response body that category deleted")
    public void receiveDeleteCategoryResponse(){
        deleteCategory.receiveCategoryResponseBody();
    }

    @Given("I set API endpoint for delete category with invalid ID")
    public void setDeleteInValidCategory(){
        deleteCategory.setApiDeleteInvalidIdCategoryEndpoint();
    }
    @When("I send request endpoint for delete category with invalid ID")
    public void sendInvalidDeleteCategoryRequest(){
        deleteCategory.sendInvalidDeleteCategoryUserRequest();
    }
}
