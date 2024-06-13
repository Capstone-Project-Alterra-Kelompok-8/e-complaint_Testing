package starter.user.Complaint_Processes;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteComplaintProcess {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for delete complaint process with valid ID")
    public String setApiDeleteComplaintProcessEndpoint() {
        return url + "/complaints/C-8ksh&s9280/processes/3";
    }

    @Step("I send request endpoint for delete complaint process")
    public void sendDeleteComplaintProcessUserRequest() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .delete(setApiDeleteComplaintProcessEndpoint());
    }
    @Step("I receive response body that complaint process deleted")
    public void receiveComplaintProcessResponseBody() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Delete Complaint Process")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}