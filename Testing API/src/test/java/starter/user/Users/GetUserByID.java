package starter.user.Users;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class GetUserByID {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for get user with valid id")
    public String setApiMyUserById(){
        return url + "/users/9";
    }

    @Step("I send request to get user information with valid ID")
    public void sendRequestMyUserById(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTIsIm5hbWUiOiJteV9hY2NvdW50X2ZlciIsImVtYWlsIjoibWFubnBlcmlpMTZAZ21haWwuY29tIiwicm9sZSI6InVzZXIifQ.nN5RUaMMDeooPpKtjMnlIhTXVy-rWWKr_t2arrlLlzI";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type","application/json")
                .get(setApiMyUserById());
    }

    @Step("I receive detail user information with valid ID")
    public void receiveValidUserById(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_USER_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Get User By ID")));
        restAssuredThat(response -> response.body("'data'.'id'",Matchers.equalTo(9)));
        restAssuredThat(response -> response.body("'data'.'name'",Matchers.equalTo("test3")));
        restAssuredThat(response -> response.body("'data'.'email'",Matchers.equalTo("abcd3@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'telephone_number'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'profile_photo'",Matchers.equalTo("profile-photos/default.jpg")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

}