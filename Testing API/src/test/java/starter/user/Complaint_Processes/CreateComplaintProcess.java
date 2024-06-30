package starter.user.Complaint_Processes;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreateComplaintProcess {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for create a complaint process")
    public String setApiForNewComplaintProcess() {
        return url + "/complaints/C-3f4201e336/processes";
    }

    @Step("I send request endpoint for create a complaint process with valid credentials")
    public void sendCreateComplaintProcessRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("status", "Verifikasi");
        requestBody.put("message", "Aduan anda telah diverifikasi");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiForNewComplaintProcess());
    }
    @Step("I receive valid data for complaint process")
    public void receiveValidDataForCreateNewComplaintProcess() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_COMPLAINT_PROCESS_SCHEMA);
        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Create Complaint Process")));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'complaint_id'", Matchers.equalTo("C-3f4201e336")));
        restAssuredThat(response -> response.body("'data'.'status'", Matchers.equalTo("Verifikasi")));
        restAssuredThat(response -> response.body("'data'.'message'", Matchers.equalTo("Aduan anda telah diverifikasi")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I send request endpoint for create a complaint process with invalid status")
    public void sendInvalidCreateComplaintProcessRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("status", "sedang diproses");
        requestBody.put("message", "Aduan anda sedang diproses");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiForNewComplaintProcess());
    }
    @Step("I receive error message that invalid status")
    public void receiveInValidDataForCreateNewComplaintProcess() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(false)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("invalid status")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
