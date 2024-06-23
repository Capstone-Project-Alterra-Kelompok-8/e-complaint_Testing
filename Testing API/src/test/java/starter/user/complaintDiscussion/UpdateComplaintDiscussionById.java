package starter.user.complaintDiscussion;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateComplaintDiscussionById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set a valid API endpoint and method")
    public String setWithValidApiEndpointAndMethod() {
        return url + "/complaints/C-1da0192be5/discussions/9";
    }

    @Step("I send a request to update complaint discussion by ID")
    public void sendARequestToUpdateComplaintDiscussionById() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "alpa");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setWithValidApiEndpointAndMethod());
    }

    @Step("I receive on status code 200 OK")
    public void receiveOnStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see complaint discussion has been update with valid")
    public void seeComplaintDiscussionHasBeenUpdateWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_COMPLAINT_DISCUSSION_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set with valid API endpoint and with wrong method")
    public String setWithValidApiEndpointAndWithWrongMethod() {
        return url + "/complaints/C-81jas92581/discussions/30";
    }

    @Step("I send a request to update complaint discussion by ID with invalid method")
    public void sendARequestToUpdateComplaintDiscussionByIdWithInvalidMethod() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "alpa");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .patch(setWithValidApiEndpointAndWithWrongMethod());
    }
    @Step("I receive status 404 not found")
    public void receiveStatus404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with valid method and an incorrect endpoint")
    public String setWithValidMethodAndAnIncorrectEndpoint() {
        return url + "/complaints/C-81jas92581/discussion/30";
    }

    @Step("I send request to update complaint discussion by ID with invalid endpoint")
    public void sendRequestToUpdateComplaintDiscussionByIdWithInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "alpa");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setWithValidMethodAndAnIncorrectEndpoint());
    }
    @Step("I received status 404 not found")
    public void receivedStatus404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with valid method and an invalid API endpoint ID")
    public String setWithValidMethodAndAnInvalidApiEndpointId() {
        return url + "/complaints/CC-81jas92581/discussions/300";
    }
    @Step("I send a request to update complaint discussion by ID with invalid ID")
    public void sendARequestToUpdateComplaintDiscussionByIdWithInvalidId() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "alpa");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setWithValidMethodAndAnInvalidApiEndpointId());
    }
    @Step("I received 404 not found")
    public void received404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
