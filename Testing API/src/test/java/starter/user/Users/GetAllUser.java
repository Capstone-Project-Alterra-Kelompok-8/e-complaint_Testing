package starter.user.Users;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllUser {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for get all users")
    public String setApiAllUser(){
        return url + "/users";
    }

    @Step("I send request to get all users")
    public void sendRequestAllUser(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type","application/json")
                .get(setApiAllUser());
    }

    @Step("I receive all of users")
    public void receiveValidUser(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_USER_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Get All Users")));
        restAssuredThat(response -> response.body("'data'.'id'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'name'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'email'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'telephone_number'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'profile_photo'",notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

}