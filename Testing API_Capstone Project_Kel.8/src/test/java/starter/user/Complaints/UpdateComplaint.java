package starter.user.Complaints;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateComplaint {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint for update complaint user")
    public String setApiUpdateComplaint(){
        return url + "/complaints/C-6fe3560eda";
    }

    @Step("I send request to update complaint user")
    public void sendPutRequestUpdateComplaint(){
        File sampleFile = new File("src/test/resources/tanahlongsor.jpeg");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("regency_id", "3604")
                .multiPart("category_id", "7")
                .multiPart("address", "Jl. pemuda no 31, RT. 04 RW. 05, Lorem ipsum, Indonesia")
                .multiPart("type","public")
                .multiPart("description", "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet")
                .multiPart("files",sampleFile)
                .put(setApiUpdateComplaint());
    }
    @Step("I should get data complaint that I updated")
    public void receiveComplaintDataUpdated(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_COMPLAINT_SCHEMA);


        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
