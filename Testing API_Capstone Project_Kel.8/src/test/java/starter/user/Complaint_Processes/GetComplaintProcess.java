package starter.user.Complaint_Processes;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetComplaintProcess {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint with an valid ID to get complaint process by valid ID")
    public String setApiGetEndValidComplaintProcessID() {
        return url + "/complaints/C-18581bec2f/processes";
    }

    @Step("I send request endpoint for get complaint process by ID")
    public void sendGetRequestValidComplaintProcessID() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiGetEndValidComplaintProcessID());
    }
    @Step("I receive complaint process information based on id by valid ID")
    public void receiveValidComplaintProcessID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_COMPLAINT_PROCESS_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get Complaint Process")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I set API endpoint with an valid ID to get complaint process by invalid ID")
    public String setApiGetEndInValidComplaintProcessID() {
        return url + "/complaints/ABCD/processes";
    }
    @Step("I send request endpoint for get complaint process by invalid ID")
    public void sendGetRequestInValidComplaintProcessID() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiGetEndInValidComplaintProcessID());
    }
}
