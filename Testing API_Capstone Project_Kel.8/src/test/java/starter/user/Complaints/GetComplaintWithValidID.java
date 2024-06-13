package starter.user.Complaints;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetComplaintWithValidID {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint with an valid ID to get admin by ID")
    public String setApiGetEndValidComplaint(){
        return url + "/complaints/C-8ksh&s9280";
    }

    @Step("I send GET request endpoint for get admin by ID")
    public void sendGetRequestValidComplaint(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiGetEndValidComplaint());
    }
    @Step("I receive admin information based on id by ID")
    public void receiveValidIDComplaint(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_COMPLAINT_WITH_VALID_ID_SCHEMA);


        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get Report")));
        restAssuredThat(response -> response.body("'data'.'id'", Matchers.equalTo("C-8ksh&s9280")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
