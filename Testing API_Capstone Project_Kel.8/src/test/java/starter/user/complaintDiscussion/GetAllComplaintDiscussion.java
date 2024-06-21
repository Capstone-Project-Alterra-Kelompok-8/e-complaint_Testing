package starter.user.complaintDiscussion;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllComplaintDiscussion {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set the valid API endpoint and method")
    public String setTheValidApiEndpointAndMethod() {
        return url + "/complaints/C-1da0192be5/discussions";
    }

    @Step("I send a request to get all complaint discussion")
    public void sendARequestToGetAllComplaintDiscussion() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywibmFtZSI6IkFkbWluIExlYmFrIiwiZW1haWwiOiJhZG1pbl9sZWJha0BnbWFpbC5jb20iLCJyb2xlIjoiYWRtaW4ifQ.roie-yu17r6GOyeWNj8182oLwSzyOp-CC2fxc8QedcA";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setTheValidApiEndpointAndMethod());
    }

    @Step("I receive status code 200 OK")
    public void receiveStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all complaint discussion with valid")
    public void getAllComplaintDiscussionWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_COMPLAINT_DISCUSSION_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set the valid API endpoint and incorrect method")
    public String setTheValidApiEndpointAndIncorrectMethod() {
        return url + "/complaints/C-81jas92581/discussions";
    }

    @Step("I send request to get all complaint discussion with invalid method")
    public void sendRequestToGetAllComplaintDiscussionWithInvalidMethod() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setTheValidApiEndpointAndIncorrectMethod());
    }

    @Step("I receive a 404 Not Found status code")
    public void receiveA404StatusCode(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set a valid method and an incorrect API endpoint")
    public String setAValidMethodAndAnIncorrectApiEndpoint() {
        return url + "/complaints/C-81jas92581/discussion";
    }

    @Step("I send request to get all complaint discussion with invalid endpoint")
    public void sendRequestToGetAllComplaintDiscussionWithInvalidEndpoint() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAValidMethodAndAnIncorrectApiEndpoint());
    }
    @Step("I receive a status code 404 not found")
    public void receiveAStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
