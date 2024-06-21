package starter.user.Admins;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreateAdminAccount {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for create a new admin account")
    public String setApiNewAdminAccount() {
        return url + "/admins";
    }

    @Step("I send request endpoint for create a new admin account with valid credentials")
    public void sendCreateAdminRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "testing_test");
        requestBody.put("email", "polisi1@gmail.com");
        requestBody.put("telephone_number", "089999");
        requestBody.put("password","password");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiNewAdminAccount());
    }

    @Step("I receive valid data for my new account")
    public void receiveValidDataForCreateNewAdmin() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_ADMIN_ACCOUNT_SCHEMA);
        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Create Account")));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'name'", Matchers.equalTo("testing_test")));
        restAssuredThat(response -> response.body("'data'.'email'", Matchers.equalTo("polisi1@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'telephone_number'", Matchers.equalTo("089999")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
