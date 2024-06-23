package starter.user.Admins;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllAdmin {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for get all admin")
    public String setApiEndGetAllAdmin(){
        return url + "/admins";
    }

    @Step("I send request endpoint for get all admin")
    public void sendRequestAdmin(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiEndGetAllAdmin());
    }

    @Step("I receive data for all admin information")
    public void receiveValidAdmin(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ADMIN_SCHEMA);
        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Get All Admins")));
        restAssuredThat(response -> response.body("'data'.'id'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'name'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'email'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'password'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'telephone_number'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'is_super_admin'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'profile_photo'",notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}