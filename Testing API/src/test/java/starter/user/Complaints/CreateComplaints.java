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

public class CreateComplaints {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";
    @Step("I set API endpoint for create new complaints")
    public String setApiNewComplaint() {
        return url + "/complaints";
    }

    @Step("I send request endpoint for create new complaints with valid credentials")
    public void sendCreateComplaint() {
        File sampleFile = new File("src/test/resources/melewatijalanberlubang.jpg");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywibmFtZSI6Ik11aGFtbWFkIElxYmFsIiwiZW1haWwiOiJtdWhhbW1hZGlxYmFsQGdtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIn0.aVe1vWDl25I0zlIPuXZ8z4p3htE0dsar5Ck-oQNdRo8";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("regency_id", "3602")
                .multiPart("category_id", "4")
                .multiPart("address", "Jl. pemuda no 31, RT. 04 RW. 05, Lorem ipsum, Indonesia")
                .multiPart("type","public")
                .multiPart("description", "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet")
                .multiPart("files",sampleFile)
                .multiPart("date", "13-06-2024")
                .post(setApiNewComplaint());
    }

    @Step("I receive valid data for my complaints")
    public void receiveValidDataForNewComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_COMPLAINT_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Create Report")));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'category'.'id'", Matchers.equalTo(4)));
        restAssuredThat(response -> response.body("'data'.'regency'.'id'", Matchers.equalTo("3602")));
        restAssuredThat(response -> response.body("'data'.'address'", Matchers.equalTo("Jl. pemuda no 31, RT. 04 RW. 05, Lorem ipsum, Indonesia")));
        restAssuredThat(response -> response.body("'data'.'type'", Matchers.equalTo("public")));
        restAssuredThat(response -> response.body("'data'.'description'", Matchers.equalTo("Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet")));
        restAssuredThat(response -> response.body("'data'.'files'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'created_at'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I send request endpoint for create new complaints with Invalid credentials(Invalid category_id)")
    public void sendInvalidCreateComplaint() {
        File sampleFile = new File("src/test/resources/melewatijalanberlubang.jpg");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywibmFtZSI6Ik11aGFtbWFkIElxYmFsIiwiZW1haWwiOiJtdWhhbW1hZGlxYmFsQGdtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIn0.aVe1vWDl25I0zlIPuXZ8z4p3htE0dsar5Ck-oQNdRo8";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("regency_id", "3602")
                .multiPart("category_id", "400")
                .multiPart("address", "Jl. pemuda no 31, RT. 04 RW. 05, Lorem ipsum, Indonesia")
                .multiPart("type","public")
                .multiPart("description", "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet")
                .multiPart("files",sampleFile)
                .multiPart("date", "13-06-2024")
                .post(setApiNewComplaint());
    }

}
