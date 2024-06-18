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
        return url + "/complaints/C-2643e92ffc";
    }

    @Step("I send request to update complaint user by valid credentials")
    public void sendPutRequestUpdateComplaint(){
        File sampleFile = new File("src/test/resources/tanahlongsor.jpeg");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTIsIm5hbWUiOiJteV9hY2NvdW50X2ZlciIsImVtYWlsIjoibWFubnBlcmlpMTZAZ21haWwuY29tIiwicm9sZSI6InVzZXIifQ.nN5RUaMMDeooPpKtjMnlIhTXVy-rWWKr_t2arrlLlzI";
        SerenityRest.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("regency_id", "3604")
                .multiPart("category_id", "7")
                .multiPart("address", "Jl. pemuda no 31, RT. 04 RW. 05, Lorem ipsum, Indonesia")
                .multiPart("type","public")
                .multiPart("description", "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet")
                .multiPart("date","02-05-2024")
                .multiPart("files",sampleFile)
                .put(setApiUpdateComplaint());
    }
    @Step("I should get data complaint that I updated")
    public void receiveComplaintDataUpdated(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_COMPLAINT_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Update Report")));
        restAssuredThat(response -> response.body("'data'.'id'", Matchers.equalTo("C-2643e92ffc")));
        restAssuredThat(response -> response.body("'data'.'category'.'id'", Matchers.equalTo(7)));
        restAssuredThat(response -> response.body("'data'.'regency'.'id'", Matchers.equalTo("3604")));
        restAssuredThat(response -> response.body("'data'.'address'", Matchers.equalTo("Jl. pemuda no 31, RT. 04 RW. 05, Lorem ipsum, Indonesia")));
        restAssuredThat(response -> response.body("'data'.'type'", Matchers.equalTo("public")));
        restAssuredThat(response -> response.body("'data'.'description'", Matchers.equalTo("Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet")));
        restAssuredThat(response -> response.body("'data'.'files'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'created_at'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I send request to update complaint user by invalid credentials(invalid regency_id)")
    public void sendPutInvalidRequestUpdateComplaint(){
        File sampleFile = new File("src/test/resources/tanahlongsor.jpeg");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTIsIm5hbWUiOiJteV9hY2NvdW50X2ZlciIsImVtYWlsIjoibWFubnBlcmlpMTZAZ21haWwuY29tIiwicm9sZSI6InVzZXIifQ.nN5RUaMMDeooPpKtjMnlIhTXVy-rWWKr_t2arrlLlzI";
        SerenityRest.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("regency_id", "360")
                .multiPart("category_id", "7")
                .multiPart("address", "Jl. pemuda no 31, RT. 04 RW. 05, Lorem ipsum, Indonesia")
                .multiPart("type","public")
                .multiPart("description", "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet")
                .multiPart("date","02-05-2024")
                .multiPart("files",sampleFile)
                .put(setApiUpdateComplaint());
    }
    @Step("I receive error message that regency not found")
    public void receiveErrorMessageUpdateComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(false)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("regency not found")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
