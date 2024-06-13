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

public class UpdateUser {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set users api endpoint for update user")
    public String setApiUpdateUser(){
        return url + "/users/update-profile";
    }

    @Step("I send request to update user with valid credentials")
    public void sendPUTupdateUser(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "testing_my_updated");
        requestBody.put("email", "mannperii16@gmail.com");
        requestBody.put("telephone_number", "08256952663");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTIsIm5hbWUiOiJteV9hY2NvdW50X2ZlciIsImVtYWlsIjoibWFubnBlcmlpMTZAZ21haWwuY29tIiwicm9sZSI6InVzZXIifQ.nN5RUaMMDeooPpKtjMnlIhTXVy-rWWKr_t2arrlLlzI";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setApiUpdateUser());
    }

    @Step("I receive newly updated user")
    public void receiveValidUser(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_USER_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Update User")));
        restAssuredThat(response -> response.body("'data'.'id'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'name'",Matchers.equalTo("testing_my_updated")));
        restAssuredThat(response -> response.body("'data'.'email'",Matchers.equalTo("mannperii16@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'telephone_number'",Matchers.equalTo("08256952663")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}