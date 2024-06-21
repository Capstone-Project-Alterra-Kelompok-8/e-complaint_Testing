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

public class AddNewUser {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";
    @Step("I set users API endpoint for create new user")
    public String setApiNewUser() {
        return url + "/users/register";
    }

    @Step("I send request endpoint for create new user")
    public void sendCreateUser() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Naruto Gagah1");
        requestBody.put("email", "Ketir12@gmail.com");
        requestBody.put("telephone_number", "089777777");
        requestBody.put("password","password");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiNewUser());
    }

    @Step("I receive valid data for my user")
    public void receiveValidDataForNewUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ADD_NEW_USER_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Register")));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'name'", Matchers.equalTo("Naruto Gagah1")));
        restAssuredThat(response -> response.body("'data'.'email'", Matchers.equalTo("Ketir12@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'telephone_number'", Matchers.equalTo("089777777")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}