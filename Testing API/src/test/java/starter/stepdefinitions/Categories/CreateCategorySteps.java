package starter.stepdefinitions.Categories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Categories.CreateCategory;

public class CreateCategorySteps {
    @Steps
    CreateCategory createCategory;

    @Given("I set API endpoint for create a new category")
    public void setApiNewCategory(){
        createCategory.setApiForNewCategory();
    }

    @When("I send request endpoint for create a new category with valid credentials")
    public void sendRequestNewCategory(){
        createCategory.sendCreateCategoryRequest();
    }

    @And("I receive valid data for new category")
    public void receiveNewCategory(){
        createCategory.receiveValidDataForCreateNewCategory();
    }

    @When("I sent the endpoint a request to create a new category by leaving one of the fields blank")
    public void sendRequestNewCategoryWithBlankField(){
        createCategory.sendCreateCategoryBlankFieldRequest();
    }
}
