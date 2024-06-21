package starter.user.Complaint_Processes;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateComplaintProcess {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for update complaint process by valid credentials")
    public String setApiUpdateComplaintProcess(){
        return url + "/complaints/C-0ea85ed770/processes/36";
    }

    @Step("I send request to update complaint process")
    public void sendPutRequestUpdateComplaintProcess(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("message", "Aduan anda sedang diverifikasi. Mohon Tunggu")
                .put(setApiUpdateComplaintProcess());
    }
    @Step("I should get data complaint process that I updated")
    public void receiveComplaintProcessDataUpdated(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_COMPLAINT_PROCESS_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Update Complaint Process")));
        restAssuredThat(response -> response.body("'data'.'id'", Matchers.equalTo(36)));
        restAssuredThat(response -> response.body("'data'.'complaint_id'", Matchers.equalTo("C-0ea85ed770")));
        restAssuredThat(response -> response.body("'data'.'status'", Matchers.equalTo("Verifikasi")));
        restAssuredThat(response -> response.body("'data'.'message'", Matchers.equalTo("Aduan anda sedang diverifikasi. Mohon Tunggu")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I send request to update complaint process by blank field")
    public void sendPutBlankFieldRequestUpdateComplaintProcess(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("message", "")
                .put(setApiUpdateComplaintProcess());
    }
}
