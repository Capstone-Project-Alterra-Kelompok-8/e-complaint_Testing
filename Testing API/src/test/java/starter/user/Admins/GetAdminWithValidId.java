package starter.user.Admins;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAdminWithValidId {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint with an valid ID to get admin by ID")
    public String setApiGetEndValidAdmin(){
        return url + "/admins/4";
    }

    @Step("I send request endpoint for get admin by ID")
    public void sendGetRequestValidAdmin(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiGetEndValidAdmin());
    }

    @Step("I receive admin information based on id by ID")
    public void receiveAdmin(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ADMIN_WITH_VALID_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Get Admin By ID")));
        restAssuredThat(response -> response.body("'data'.'id'",Matchers.equalTo(4)));
        restAssuredThat(response -> response.body("'data'.'name'",Matchers.equalTo("Admin Serang")));
        restAssuredThat(response -> response.body("'data'.'email'",Matchers.equalTo("admin_serang@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'password'",notNullValue()));
        restAssuredThat(response -> response.body("'data'.'telephone_number'",Matchers.equalTo("081234567890")));
        restAssuredThat(response -> response.body("'data'.'is_super_admin'",Matchers.equalTo(false)));
        restAssuredThat(response -> response.body("'data'.'profile_photo'",Matchers.equalTo("profile-photos/admin-default.jpg")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}