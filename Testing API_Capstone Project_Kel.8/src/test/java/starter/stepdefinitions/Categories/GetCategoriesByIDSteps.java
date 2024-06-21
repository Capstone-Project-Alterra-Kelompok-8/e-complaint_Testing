package starter.stepdefinitions.Categories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Categories.GetCategoriesByID;

public class GetCategoriesByIDSteps {
    @Steps
    GetCategoriesByID getCategoriesByID;

    @Given("I set API endpoint with an valid ID to get category by valid ID")
    public void setApiGetEndValidIDCategories(){
        getCategoriesByID.setApiGetEndValidCategories();
    }

    @When("I send request endpoint for get category")
    public void sendGetRequestValidIDCategories(){
        getCategoriesByID.sendGetRequestValidCategories();
    }

    @And("I receive category information based on id")
    public void receiveDetailsValidIDCategories(){
        getCategoriesByID.receiveValidIDCategories();
    }

    @Given("I set API endpoint with an valid ID to get category by invalid ID")
    public void setApiGetEndInValidIDCategories(){
        getCategoriesByID.setApiGetEndInValidCategories();
    }

    @When("I send request endpoint for get category by invalid ID")
    public void sendGetRequestInValidIDCategories(){
        getCategoriesByID.sendGetRequestInValidCategories();
    }
}
