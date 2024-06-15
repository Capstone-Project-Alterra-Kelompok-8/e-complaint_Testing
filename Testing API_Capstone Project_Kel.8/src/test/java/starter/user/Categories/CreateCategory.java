package starter.user.Categories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreateCategory {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for create a new category")
    public String setApiForNewCategory() {
        return url + "/categories";
    }

    @Step("I send request endpoint for create a new category with valid credentials")
    public void sendCreateCategoryRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "New Complaint Category");
        requestBody.put("description", "Lorem ipsum dolor sit amet");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiForNewCategory());
    }
    @Step("I receive valid data for new category")
    public void receiveValidDataForCreateNewCategory() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_CATEGORY_SCHEMA);
        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success create category")));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'name'", Matchers.equalTo("New Complaint Category")));
        restAssuredThat(response -> response.body("'data'.'description'", Matchers.equalTo("Lorem ipsum dolor sit amet")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I sent the endpoint a request to create a new category by leaving one of the fields blank")
    public void sendCreateCategoryBlankFieldRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "New Complaint Category");
        requestBody.put("description", "");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiForNewCategory());
    }
}
