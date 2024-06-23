package starter.user.Complaints;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateImportComplaint {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";
    @Step("I set API endpoint for create new import complaint")
    public String setApiNewImportComplaint() {
        return url + "/complaints/import";
    }

    @Step("I send request endpoint for create new import complaint")
    public void sendCreateImportComplaint() {
        File sampleFile = new File("src/test/resources/FileTemplateImportComplaint.xlsx");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("file",sampleFile)
                .post(setApiNewImportComplaint());
    }
    @Step("I receive valid status for import complaints was success")
    public void receiveStatusDataForNewImportComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("Success Import Report")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
