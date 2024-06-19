package starter.user.Complaints;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteComplaint {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for delete complaint with valid ID")
    public String setApiDeleteComplaintEndpoint() {
        return url + "/complaints/C-47737407a7";
    }

    @Step("I send request endpoint for delete complaint")
    public void sendDeleteComplaintUserRequest() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .delete(setApiDeleteComplaintEndpoint());
    }
    @Step("I receive response body that complaint deleted")
    public void receiveComplaintResponseBody() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Delete Report")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I set API endpoint for delete complaint with Invalid ID")
    public String setApiInvalidDeleteComplaintEndpoint() {
        return url + "/complaints/ABCD";
    }
    @Step("I send request endpoint for delete complaint with invalid ID")
    public void sendInvalidDeleteComplaintUserRequest() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .delete(setApiInvalidDeleteComplaintEndpoint());
    }
}
