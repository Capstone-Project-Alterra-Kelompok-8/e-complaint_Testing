package starter.user.complaintDiscussion;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreateComplaintDiscussion {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set on valid API endpoint and method")
    public String setOnValidApiEndpointAndMethod() {
        return url + "/complaints/C-81jas92581/discussions";
    }

    @Step("I send a request to create complaint discussion")
    public void sendARequestToCreateComplaintDiscussion() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "bravo");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setOnValidApiEndpointAndMethod());
    }

    @Step("I receive on status code 201 created")
    public void receiveOnStatusCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I create complaint discussion with valid")
    public void createComplaintDiscussionWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_COMPLAINT_DISCUSSION_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set on valid API endpoint and incorrect method")
    public String setOnValidApiEndpointAndIncorrectMethod() {
        return url + "/complaints/C-81jas92581/discussions";
    }

    @Step("I send request to create complaint discussion with invalid method")
    public void sendRequestToCreateComplaintDiscussionWithInvalidMethod() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "bravo");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .patch(setOnValidApiEndpointAndIncorrectMethod());
    }

    @Step("I receive on 404 not found status code")
    public void receiveOn404StatusCode(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set on valid method and an incorrect API endpoint")
    public String setOnValidMethodAndAnIncorrectApiEndpoint() {
        return url + "/complaints/C-81jas92581/discussion";
    }

    @Step("I send request to create complaint discussion with invalid endpoint")
    public void sendRequestToCreateComplaintDiscussionWithInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "bravo");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setOnValidMethodAndAnIncorrectApiEndpoint());
    }
    @Step("I receive code 404 not found")
    public void receiveCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
