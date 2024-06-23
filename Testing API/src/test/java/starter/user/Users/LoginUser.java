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

public class LoginUser {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint to Login User")
    public String setApiUserLogin() {
        return url + "/users/login";
    }

    @Step("I send request to login User and fill valid credential(email, password)")
    public void sendUserLoginValid() {

        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "muhammadiqbal@gmail.com");
        requestBody.put("password", "password");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiUserLogin());
    }

    @Step("I receive my logged in account data user")
    public void receiveValidUserLogin() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_USER_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Login")));
        restAssuredThat(response -> response.body("'data'.'id'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'name'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'email'",Matchers.equalTo("muhammadiqbal@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'token'",notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
