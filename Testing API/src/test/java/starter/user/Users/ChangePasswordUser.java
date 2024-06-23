package starter.user.Users;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class ChangePasswordUser {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";
    @Step("I set API endpoint for change password user")
    public String setApiPassUser() {
        return url + "/users/change-password";
    }

    @Step("I send request endpoint for change password user with valid credentials")
    public void sendPassUser() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("new_password", "password");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTIsIm5hbWUiOiJteV9hY2NvdW50X2ZlciIsImVtYWlsIjoibWFubnBlcmlpMTZAZ21haWwuY29tIiwicm9sZSI6InVzZXIifQ.nN5RUaMMDeooPpKtjMnlIhTXVy-rWWKr_t2arrlLlzI";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setApiPassUser());
    }

    @Step("I receive valid data for my user")
    public void receiveValidDataForPassUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Update Password")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
