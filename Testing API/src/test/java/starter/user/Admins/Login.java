package starter.user.Admins;

import io.restassured.http.ContentType;
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

public class Login {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint to Login admin")
    public String setApiLogin() {
        return url + "/admins/login";
    }

    @Step("I send request to login and fill valid credential")
    public void sendLoginValid() {

        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "super_admin@gmail.com");
        requestBody.put("password", "password");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiLogin());
    }

    @Step("I receive my logged in account data and get token")
    public void receiveValidLogin() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_ADMIN_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Login")));
        restAssuredThat(response -> response.body("'data'.'id'",Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("'data'.'name'",Matchers.equalTo("Super Admin")));
        restAssuredThat(response -> response.body("'data'.'email'",Matchers.equalTo("super_admin@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'is_super_admin'",Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("'data'.'token'",notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}