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

        requestBody.put("name", "Muhammad Iqbal");
        requestBody.put("email", "muhammadiqbal@gmail.com");
        requestBody.put("telephone_number", "08256952663");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywibmFtZSI6Ik11aGFtbWFkIElxYmFsIiwiZW1haWwiOiJtdWhhbW1hZGlxYmFsQGdtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIn0.aVe1vWDl25I0zlIPuXZ8z4p3htE0dsar5Ck-oQNdRo8";
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
        restAssuredThat(response -> response.body("'data'.'name'",Matchers.equalTo("Muhammad Iqbal")));
        restAssuredThat(response -> response.body("'data'.'email'",Matchers.equalTo("muhammadiqbal@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'telephone_number'",Matchers.equalTo("08256952663")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}