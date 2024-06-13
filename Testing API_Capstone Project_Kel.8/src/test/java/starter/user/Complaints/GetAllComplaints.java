package starter.user.Complaints;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllComplaints {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for get all admin")
    public String setApiEndGetAllComplaints() {
        return url + "/complaints?sort_by=id&sort_type=desc";
    }

    @Step("I send GET request endpoint for get all admin")
    public void sendRequestGetAllComplaints() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiEndGetAllComplaints());
    }

    @Step("I receive data for all admin information")
    public void receiveValidAllComplaints() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_COMPLAINTS_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get Reports")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}