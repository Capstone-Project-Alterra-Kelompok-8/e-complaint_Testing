package starter.user.Categories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetCategoriesByID {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint with an valid ID to get category by valid ID")
    public String setApiGetEndValidCategories() {
        return url + "/categories/2";
    }

    @Step("I send request endpoint for get category")
    public void sendGetRequestValidCategories() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiGetEndValidCategories());
    }
    @Step("I receive category information based on id")
    public void receiveValidIDCategories() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_CATEGORIES_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success get category by ID")));
        restAssuredThat(response -> response.body("'data'.'ID'", Matchers.equalTo(2)));
        restAssuredThat(response -> response.body("'data'.'Name'", Matchers.equalTo("Pendidikan")));
        restAssuredThat(response -> response.body("'data'.'Description'", Matchers.equalTo("Kategori pengaduan yang berkaitan dengan pendidikan seperti fasilitas pendidikan, kurikulum, dan lain-lain")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I set API endpoint with an valid ID to get category by invalid ID")
    public String setApiGetEndInValidCategories() {
        return url + "/categories/100";
    }
    @Step("I send request endpoint for get category")
    public void sendGetRequestInValidCategories() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiGetEndInValidCategories());
    }
}
