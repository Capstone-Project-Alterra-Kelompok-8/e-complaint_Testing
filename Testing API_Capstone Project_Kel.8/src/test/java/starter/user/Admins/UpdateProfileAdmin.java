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

public class UpdateProfileAdmin {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for update profile admin")
    public String setApiUpdateAdmin(){
        return url + "/admins/12";
    }

    @Step("I send request to update profile admin")
    public void sendPutRequestUpdateAdmin(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "testing_qe_updated");
        requestBody.put("email", "update12@gmail.com");
        requestBody.put("telephone_number", "08256952663");
        requestBody.put("password", "password");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setApiUpdateAdmin());
    }

    @Step("I should get the data admin that I updated")
    public void receiveDataAdminUpdated(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_ADMIN_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Update Admin")));
        restAssuredThat(response -> response.body("'data'.'id'",Matchers.equalTo(12)));
        restAssuredThat(response -> response.body("'data'.'name'",Matchers.equalTo("testing_qe_updated")));
        restAssuredThat(response -> response.body("'data'.'email'",Matchers.equalTo("update12@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'password'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'telephone_number'",Matchers.equalTo("08256952663")));
        restAssuredThat(response -> response.body("'data'.'update_at'",notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}