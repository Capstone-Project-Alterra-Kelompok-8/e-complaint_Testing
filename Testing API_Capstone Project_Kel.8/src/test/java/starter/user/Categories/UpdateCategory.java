package starter.user.Categories;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateCategory {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for update category")
    public String setApiUpdateCategory(){
        return url + "/categories/9";
    }

    @Step("I send request to update category")
    public void sendPutRequestUpdateCategory(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("name", "Update Category")
                .multiPart("description", "Lorem ipsum dolor sit amet Update")
                .put(setApiUpdateCategory());
    }
    @Step("I should get data category that I updated")
    public void receiveCategoryDataUpdated(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_CATEGORY_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success update category")));
        restAssuredThat(response -> response.body("'data'.'id'", Matchers.equalTo(9)));
        restAssuredThat(response -> response.body("'data'.'name'", Matchers.equalTo("Update Category")));
        restAssuredThat(response -> response.body("'data'.'description'", Matchers.equalTo("Lorem ipsum dolor sit amet Update")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
